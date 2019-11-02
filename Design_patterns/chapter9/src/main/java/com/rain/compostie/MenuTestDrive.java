package com.rain.compostie;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU","Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU","Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU","Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU","Dessert of course!");
        MenuComponent allMenus = new Menu("ALL MENUS","ALL menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dessertMenu);
        allMenus.add(dinerMenu);
        dinerMenu.add(new MenuItem(
                "Pasta",
                "Spaghetti with Marinara Sauce ,and a slice of sourdough bread",
                true,
                3.89
        ));
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla ice cream",
                true,
                1.59
        ));
        Waitress waitress = new Waitress(allMenus);
        waitress.printMent();
    }
}
