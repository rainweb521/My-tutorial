package com.rain.demo2;

/**
 * @Author: wcy
 * @Date: 2019/11/11
 */
public class HasQuarterState implements State{
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("您不能再投入25分钱");
    }

    public void ejectQuarter() {
        System.out.println("退出25分钱");
    }

    public void turnCrank() {
        System.out.println("正在售出糖果");
    }

    public void dispense() {
        System.out.println("糖果售罄");
    }
}
