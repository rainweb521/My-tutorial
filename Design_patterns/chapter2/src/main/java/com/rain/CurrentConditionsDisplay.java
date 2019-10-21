package com.rain;

//布告板实现了Observer接口,所以可以从WeatherData对象中获得改变
public class CurrentConditionsDisplay implements Observer,DisplayElement{

    private float temperature;
    private float humidity;
    private Subject weatherData;

//    构造器需要 weatherData对象(也就是主题)作为注册之用。
    public CurrentConditionsDisplay(Subject weatherData){
        Subject subject = this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    public void display() {
        System.out.println(temperature+""+humidity);
    }

//    当update()被调用时,我们把温度和湿度保存起来, 然后调用display()。
    public void update(float temp, float humidity, float pressure) {

        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
