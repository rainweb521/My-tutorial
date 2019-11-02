package com.rain;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    Command undoCommand;
    /**
     * 初始化这两个开关的数组
     */
    public RemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0 ;i < 7;i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    /**
     * 有三个命令，分别是插槽位置，开的命令，关的命令
     * @param slot
     * @param onCommand
     * @param offCommand
     */
    public void setCommand(int slot ,Command onCommand,Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }
    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }
    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushhed(){
        undoCommand.undo();
    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n-------Remote Control ------\n");
        for (int i = 0 ;i < onCommands.length;i++){
            stringBuffer.append("[slot"+i+"]"+onCommands[i].getClass().getName()+"        "
            +offCommands[i].getClass().getName()+"\n");
        }
        return stringBuffer.toString();
    }
}
