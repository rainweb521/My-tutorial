package com.rain;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingroomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
//        ceilingFan = new

        LightOnCommand LivingRoomlightOnCommand = new LightOnCommand(livingroomLight);
        LightOffCommand LivingRoomlightOffCommand = new LightOffCommand(livingroomLight);
        LightOnCommand KitchenlightOnCommand = new LightOnCommand(livingroomLight);
        LightOffCommand KitchenlightOffCommand = new LightOffCommand(kitchenLight);

//        添加命令
        remoteControl.setCommand(0,LivingRoomlightOnCommand,LivingRoomlightOffCommand);

//        打印遥控器里的信息
        System.out.println(remoteControl);

//        执行开关
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
    }

}
