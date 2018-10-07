package com.example.springboot2.Controller;

import com.example.springboot2.SocketHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/weather")
public class Controller   {
    public static Map<String,Object> data=new HashMap<String, Object>();

    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient eurekaClient;


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateWeather(@RequestParam(value="json_data")  String json_data){
        JSONObject json = new JSONObject(json_data);
        for(String key : json.keySet()){
            data.put(key,json.get(key));
        }
        System.out.println(json_data);
        for (Object session : SocketHandler.sessions ) {
            try {
                ((WebSocketSession)session).sendMessage(new TextMessage(json_data));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public Map<String,Object> show(){
        return data;
    }

}
