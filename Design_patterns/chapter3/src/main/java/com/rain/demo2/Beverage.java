package com.rain.demo2;

public abstract class Beverage {
    String description = "Unknown Beverage";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
