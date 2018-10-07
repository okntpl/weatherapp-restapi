package com.example.springboot2;

import com.example.springboot2.Controller.Controller;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient

public class Springboot2Application {

	@Autowired
	public EurekaClient eurekaClient;

	public static void main(String[] args) {

		SpringApplication.run(Springboot2Application.class, args);

	}

	@Bean
	public SmartInitializingSingleton initializingSingleton(){
		return () -> {
			String serviceUrl=getServiceUrl("project1");
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
			parts.add("serviceName", "project2");
			restTemplate.postForEntity(serviceUrl + "/weather/registerObserver", parts, Void.class);
		};
	}

	public String getServiceUrl(String serviceName) {

		InstanceInfo instance = eurekaClient.getNextServerFromEureka(serviceName, false);
		return instance.getHomePageUrl();
	}






}
