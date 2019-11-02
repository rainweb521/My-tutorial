package com.rain;

public class SimpleRemoteController {
//    插槽持有命令，而这个命令控制着一个装置
    Command slot;

    public SimpleRemoteController() { }

//    用来设置插槽控制的命令，如果想要改变命令，可以多次调用
    public void setCommand(Command command) {
        this.slot = command;
    }
//    按下按钮，方法就会被调用
    public void buttonWasPressed(){
        slot.execute();
    }
}
