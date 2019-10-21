package com.rain.demo1;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    public String getName() {
        return name;
    }

    public void prepare() {
    }

    public void bake() {
    }

    public void cut() {
    }

    public void box() {
    }
}
