package com.rain.demo2;

import com.rain.demo1.Pizza;
import com.rain.demo1.SimplePizzaFactory;

public abstract class PizzaStore {
    SimplePizzaFactory factory;
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    abstract Pizza createPizza(String type);



}
