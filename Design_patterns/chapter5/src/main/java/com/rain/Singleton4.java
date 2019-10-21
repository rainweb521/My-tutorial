package com.rain;

public class Singleton4 {

//    利用一个静态变量来记录Singleton类对唯一实例
//    volatile并健词确保:当uniqueInstance变量被初始化成Singleton实例时,
//    多个线程正确的处理uniqueInstance变量
    private volatile static Singleton4 uniqueInstance;

//    把构造器声明为私有的，只有自Singleton类内才可以调用构造器
    private Singleton4() {}

//    用getInstance方法实例化对象，并返回这个实例
//    检查实例，如果不存在，就进入同步区
    public static Singleton4 getInstance() {
//        只有第一次才彻底执行这里的代码。
        if (uniqueInstance==null){
            synchronized (Singleton4.class){
//                进入区块后，再检查一次，如果仍是null，才创建实例
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }
}
