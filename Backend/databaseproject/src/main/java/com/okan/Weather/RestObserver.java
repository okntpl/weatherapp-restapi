package com.okan.Weather;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import org.json.*;
import java.util.Map;

public class RestObserver implements Observer{
    private String serviceId;
    private EurekaClient eurekaClient;

    public String getServiceId() {
        return serviceId;
    }

    public RestObserver(EurekaClient eurekaClient, String serviceId) {
        this.eurekaClient = eurekaClient;
        this.serviceId = serviceId;
    }

    @Override
    public void update(Map<String,WeatherEntity> map) {

        String serviceUrl=getServiceUrl(serviceId);
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();

        JSONObject json = new JSONObject();
        for(Map.Entry<String,WeatherEntity> entry : map.entrySet()) {
            String key = entry.getKey();
            JSONObject jsonObject = new JSONObject(entry.getValue());
            json.put(key,jsonObject);
        }

        parts.add("json_data",json.toString());

        restTemplate.postForEntity(serviceUrl + "/weather/update", parts,Void.class);
    }

    public String getServiceUrl(String serviceName) {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka(serviceName, false);
        return instance.getHomePageUrl();
    }
}
