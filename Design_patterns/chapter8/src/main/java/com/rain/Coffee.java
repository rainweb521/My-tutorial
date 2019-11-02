package com.rain;

public class Coffee extends CaffeineBeverage{
//    用户输入的值
    private String answer;
    public void brew(){
        System.out.println("用沸水冲泡咖啡");
    }
    public void addCondimennts(){
        System.out.println("添加糖和牛奶");
    }
    //覆盖钩子，提供自己的功能
    @Override
    boolean customerWantsCondiments() {
//        让用户根据他们的输入来判断是否需要添加配料
        if (answer.toLowerCase().startsWith("y")){
            return true;
        }else {
            return false;
        }
    }
}
