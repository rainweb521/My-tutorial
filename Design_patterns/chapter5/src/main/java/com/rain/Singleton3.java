package com.rain;

public class Singleton {

//    利用一个静态变量来记录Singleton类对唯一实例
    private static Singleton uniqueInstance;

//    把构造器声明为私有的，只有自Singleton类内才可以调用构造器
    private Singleton() {}

//    用getInstance方法实例化对象，并返回这个实例
    public static Singleton getInstance() {
        if (uniqueInstance==null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
