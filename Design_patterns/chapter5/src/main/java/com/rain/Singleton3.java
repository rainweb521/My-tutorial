package com.rain;

public class Singleton3 {

//    利用一个静态变量来记录Singleton类对唯一实例
//    在静态初始化器中创建单件，这段代码保证了线程安全
    private static Singleton3 uniqueInstance = new Singleton3();

//    把构造器声明为私有的，只有自Singleton类内才可以调用构造器
    private Singleton3() {}

//    用getInstance方法实例化对象，并返回这个实例
    public static Singleton3 getInstance() {

        return uniqueInstance;
    }
}
