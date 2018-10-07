package com.okan.Weather;

import java.util.Map;

public interface Observer {

    public void update(Map<String,WeatherEntity> map);
}
