package com.okan.Weather;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Weather implements Subject{
    Map<String,WeatherEntity> cityMap;
    LinkedList<Observer> observers;




    public Weather() {

        this.observers = new LinkedList<Observer>();

    }

    @Override
    public void register(Observer o) {
        observers.add(o);
        System.out.println("REGISTER: " + ((RestObserver)o).getServiceId());
    }

    public void updateData(Map<String,WeatherEntity> cityMap){
        this.cityMap=cityMap;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for(Observer o : observers){
            o.update(cityMap);
        }
    }
}
