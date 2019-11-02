package com.rain;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator{
    ArrayList<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    public boolean hasNext() {
        if (position>=menuItems.size() || menuItems.get(position)==null){
            return false;
        }else{
            return true;
        }
    }
    public MenuItem next() {
        MenuItem menuItem = menuItems.get(position);
        position+=1;
        return menuItem;
    }
}
