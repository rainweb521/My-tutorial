package com.rain;

public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        /**
         * 残们加上了一个小的条件语句,而该条件是否成立,是由一个
         * 具体方法customerWantsCondiments()決定的。
         * 如果顾客“想要”调料,有这时我们才调用addCondimennts()
         */
        if (customerWantsCondiments()){
            addCondimennts();
        }
    }
    /**
     * 残们在这里定义了-个方法, (通常)是空的缺省实现。
     * 这个方法会返回true,不做别的事。
     * 这就是一个钩子,子类可以覆盖这个方法,但不见得一定要这么做。
     * @return
     */
    boolean customerWantsCondiments(){
        return true;
    }
    abstract void brew();
    abstract void addCondimennts();
    public void boilWater(){
        System.out.println("把水煮沸");
    }
    public void pourInCup(){
        System.out.println("倒进杯子");
    }
}
