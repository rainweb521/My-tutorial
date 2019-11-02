package com.rain;

public class DinerMenu implements Menu{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0 ;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT",
                "(Fakin') BAcon with lettuce & tomato on whole wheat",true,2.99);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        if (numberOfItems >= MAX_ITEMS){
            System.out.println("Sorry,meny is full");
        }else {
            menuItems[numberOfItems]  = menuItem;
            numberOfItems += 1;
        }
    }

    public Iterator createIterator(){
        return new DinnerMenuIterator(menuItems);
    }
    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}
