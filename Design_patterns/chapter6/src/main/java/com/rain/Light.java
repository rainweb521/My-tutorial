package com.rain;

public class Light {
    private String name;
    public Light(String living_room) {
        this.name = living_room;
    }

    public Light() {
    }

    public void on(){
        System.out.println("打开灯");
    }
    public void off(){
        System.out.println("关闭灯");
    }
}
