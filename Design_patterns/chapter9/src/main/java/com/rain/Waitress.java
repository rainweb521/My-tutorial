package com.rain;

import java.util.ArrayList;

public class Waitress {
    ArrayList menus;
    public Waitress(ArrayList menus) {
        this.menus = menus;
    }
    public void printMenu(){
        Iterator iterator = (Iterator) menus.iterator();
        while (iterator.hasNext()){
            Menu menu = (Menu) iterator.next();
            printMenu(menu.createIterator());
        }

    }
    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getDescription());
            System.out.println(menuItem.getVegetarian());
        }
    }
}
