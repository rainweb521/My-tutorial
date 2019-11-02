package com.rain;

public class DinnerMenuIterator implements Iterator {
    MenuItem[] menuItems;
    int position = 0;

    public DinnerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }
    public boolean hasNext() {
        if (position>=menuItems.length || menuItems[position]==null){
            return false;
        }else{
            return true;
        }
    }
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position+=1;
        return menuItem;
    }
}
