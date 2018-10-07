package com.okan;

import com.okan.Weather.Weather;
import com.okan.Weather.WeatherDao;
import com.okan.Weather.WeatherEntity;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableDiscoveryClient

@CrossOrigin
public class Main {

    public static Weather weather;
    public static void main(String[] args) {

        weather = new Weather();


        SpringApplication.run(Main.class, args);


    }





    }

