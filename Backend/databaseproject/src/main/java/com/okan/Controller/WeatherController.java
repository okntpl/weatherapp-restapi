package com.okan.Controller;

import com.netflix.discovery.EurekaClient;
import com.okan.Main;
import com.okan.Weather.RestObserver;
import com.okan.Weather.Weather;
import com.okan.Weather.WeatherDao;
import com.okan.Weather.WeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Qualifier("eurekaClient")
    @Autowired
    public EurekaClient eurekaClient;
    @Autowired
    private WeatherDao weatherDao;

    @RequestMapping(value = "/registerObserver", method = RequestMethod.POST)
    public void registerObserver(@RequestParam(value="serviceName") String serviceName) {
        RestObserver restObserver = new RestObserver(eurekaClient, serviceName);
        Main.weather.register(restObserver);

    }
    @RequestMapping(value="/get_data",method=RequestMethod.GET)
    public List<WeatherEntity> getData(){

        return weatherDao.findAll();
    }

    @RequestMapping(value = "/new_data", method = RequestMethod.POST)
    public boolean newData(@RequestBody WeatherEntity weatherEntity){
        weatherDao.updateByName(weatherEntity.getDistrict(),weatherEntity.getTemperature1(),weatherEntity.getTemperature2(),weatherEntity.getTemperature3());

        HashMap<String, WeatherEntity> map = new HashMap<>();
        map.put(weatherEntity.getDistrict(), weatherEntity);
        Main.weather.updateData(map);

        return true;
    }

}
