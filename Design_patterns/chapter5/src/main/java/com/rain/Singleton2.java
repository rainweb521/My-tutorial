package com.rain;

public class Singleton2 {

//    利用一个静态变量来记录Singleton类对唯一实例
    private static Singleton2 uniqueInstance;

//    把构造器声明为私有的，只有自Singleton类内才可以调用构造器
    private Singleton2() {}

//    用getInstance方法实例化对象，并返回这个实例
//    通过增加synchronized关键字到getInstance方法中，我们迫使每个
//    线程在进入这个方法之前，要先等候别的线程离开该方法。也就是说，
//    不会有两个线程可以同时进入这个方法。
    public static synchronized Singleton2 getInstance() {
        if (uniqueInstance==null){
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
}
