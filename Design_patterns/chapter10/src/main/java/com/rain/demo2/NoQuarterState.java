package com.rain.demo2;

/**
 * @Author: wcy
 * @Date: 2019/11/11
 */
public class NoQuarterState implements State{

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("您投入了25分钱");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
        System.out.println("尚未投入25分钱");
    }

    public void turnCrank() {
        System.out.println("你需要先投入25分钱");
    }

    public void dispense() {
        System.out.println("你需要投入25分钱");
    }
}
