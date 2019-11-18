package com.rain.demo2;

/**
 * @Author: wcy
 * @Date: 2019/11/11
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;
    public SoldOutState(GumballMachine gumballMachine) {
    }

    public void insertQuarter() {
        System.out.println("请稍等，我们已经在给您一个糖果");
    }

    public void ejectQuarter() {
        System.out.println("对不起，你已经拿到糖果了");
    }

    public void turnCrank() {
        System.out.println("已经没有糖果了");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount()>0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else{
            System.out.println("");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
