package com.feng.designpatterndemo.chapter2.observer;

import com.feng.designpatterndemo.chapter2.subject.Subject;

/**
 * 统计气象信息显示器
 *
 * @Author fency
 * @Date 2025/5/19 16:10
 * @Version 1.0
 */

public class StatisticsDisplay implements Observer,DisplayElement{

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Statistics conditions: " + temperature + "F degrees and " + humidity + "% humidity" + " and " + pressure + " pressure");

    }


}
