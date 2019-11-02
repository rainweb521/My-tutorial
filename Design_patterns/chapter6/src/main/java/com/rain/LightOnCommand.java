package com.rain;

public class LightOnCommand implements Command {
    Light light;
//    给构造器传入某个电灯，方便以后调用execute
    public LightOnCommand(Light light){
        this.light = light;
    }
//    调用接受对象的on方法
    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
