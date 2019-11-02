package com.rain.compostie;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }
    public void printMent(){
        allMenus.print();
    }
}
