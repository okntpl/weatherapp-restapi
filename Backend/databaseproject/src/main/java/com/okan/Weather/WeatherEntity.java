package com.okan.Weather;

import javax.persistence.*;

@Entity
public class WeatherEntity {
    @Id
    @GeneratedValue
  //  private Integer id;
    private String cityName;
    private Integer temperature1;
    private Integer temperature2;
    private Integer temperature3;
    private String distinctName;


    public WeatherEntity() {
    }

    public Integer getTemperature2() {
        return temperature2;
    }

    public void setTemperature2(Integer temperature2) {
        this.temperature2 = temperature2;
    }

    public Integer getTemperature3() {
        return temperature3;
    }

    public void setTemperature3(Integer temperature3) {
        this.temperature3 = temperature3;
    }

    public String getDistrict() {
        return distinctName;
    }

    public void setDistrict(String district) {
        this.distinctName = district;
    }

    public WeatherEntity(Integer temperature) {
        this.temperature1 = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(Integer temperature) {
        this.temperature1 = temperature;
    }

}
