package com.rain;

import java.util.ArrayList;

public class PancakeHouseMenu implements Menu{
    ArrayList menuItems;
    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("K&B Pancake Breakfast","Pancakes with scrambled eggs , and toast",
                true,2.99);
    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems.add(menuItem);
    }
    public ArrayList getMenuItems(){
        return menuItems;
    }
    public Iterator createIterator(){
        return (Iterator) menuItems.iterator();
    }
}
