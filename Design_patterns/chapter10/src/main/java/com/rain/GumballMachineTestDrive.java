package com.rain;

/**
 * @Author: wcy
 * @Date: 2019/11/8
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine.toString());
        gumballMachine.insetQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine.toString());

        gumballMachine.insetQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine.toString());
    }
}
