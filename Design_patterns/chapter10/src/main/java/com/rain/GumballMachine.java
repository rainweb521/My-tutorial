package com.rain;

/**
 * @Author: wcy
 * @Date: 2019/11/8
 */
public class GumballMachine {
//    每个状态都用一个不同的整数代表
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;
//    持有当前的状态，最开始设置为糖果售罄的状态，因为糖果机开始安装时并没有装糖果
    int state = SOLD_OUT;
//    糖果数量
    int count = 0;

//    初始化糖果数量
    public GumballMachine(int count) {
        this.count = count;
        if (count>0){
            state = NO_QUARTER;
        }
    }

//    投入25分钱
    public void insetQuarter(){
        if (state == HAS_QUARTER){
            System.out.println("您不能再投入25分钱");
        }else if (state == SOLD_OUT){
            System.out.println("您无法投入25分钱，机器售罄");
        }else if (state == SOLD){
            System.out.println("请稍等，我们已经在给您一个糖果");
        }else if (state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("您投入了25分钱");
        }
    }
//    试着退钱
    public void ejectQuarter(){
        if (state == HAS_QUARTER){
            System.out.println("退出25分钱");
            state = NO_QUARTER;
        }else if (state == NO_QUARTER){
            System.out.println("尚未投入25分钱");
        }else if (state == SOLD){
            System.out.println("对不起，你已经拿到糖果了");
        }else if (state == SOLD_OUT){
            System.out.println("糖果售罄，尚未投入25分钱");
        }
    }
//    转动曲柄
    public void turnCrank(){
        if (state == SOLD){
            System.out.println("别想拿到两次糖果");
        }else if (state == NO_QUARTER){
            System.out.println("你需要先投入25分钱");
        }else if (state == SOLD_OUT){
            System.out.println("已经没有糖果了");
        }else if (state == HAS_QUARTER){
            System.out.println("请取出糖果");
            state = SOLD;
            dispense();
        }
    }

//    发放糖果
    private void dispense() {
        if (state == SOLD){
            System.out.println("正在售出糖果");
            count = count - 1;
            if (count == 0){
                System.out.println("糖果售罄");
                state = SOLD_OUT;
            }else{
                state = NO_QUARTER;
            }
        }else if (state == NO_QUARTER){
            System.out.println("你需要投入25分钱");
        }else if (state == SOLD_OUT){
            System.out.println("操作错误");
        }else if (state == HAS_QUARTER){
            System.out.println("操作错误");
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
