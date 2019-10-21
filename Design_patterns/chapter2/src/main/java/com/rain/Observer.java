package com.rain;

public interface Observer {
//    但气象观测值改变时，主题会把这些状态值当作方法的参数，传递给观察者
    public void update(float temp,float humidity,float pressure);
}
