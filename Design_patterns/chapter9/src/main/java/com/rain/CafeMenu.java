package com.rain;

import java.util.Hashtable;

public class CafeMenu implements Menu {
    Hashtable menuItems = new Hashtable();

    public CafeMenu() {
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun , lettuce,tomato , and fries",
                true,3.99);
    }
    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(),menuItem);
    }
    public Iterator createIterator() {
        return (Iterator) menuItems.values().iterator();
    }
}
