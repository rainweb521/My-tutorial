package com.rain.demo1;

public class HouseBlend extends Beverage1 {
    private double money;
    public double cost(){
        money = money + super.cost();
       return money;
    }
}
