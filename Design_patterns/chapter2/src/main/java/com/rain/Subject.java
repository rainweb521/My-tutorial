package com.rain;

public interface Subject {
//    用来注册或删除观察者
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
//    当主题状态改变时，调用此方法通知所有观察者
    public void notifyObservers();
}
