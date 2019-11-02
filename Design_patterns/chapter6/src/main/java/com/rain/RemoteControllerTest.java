package com.rain;

public class RemoteControllerTest {
    public static void main(String[] args) {
//        实例化遥控器
        SimpleRemoteController remote = new SimpleRemoteController();
//        创建一个电灯对象，此对象就是请求接受者
        Light light = new Light();
//        创建命令，并将接收者传给它
        LightOnCommand lightOn = new LightOnCommand(light);
//        将命令传给调用者
        remote.setCommand(lightOn);
//        模拟按下按钮
        remote.buttonWasPressed();
    }
}
