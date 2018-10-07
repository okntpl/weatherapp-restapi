package com.okan.Weather;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeatherRowMapper implements RowMapper<WeatherEntity> {
    @Override
    public WeatherEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCityName(resultSet.getString("cityName"));
        weatherEntity.setDistrict(resultSet.getString("distinctName"));
        weatherEntity.setTemperature1(resultSet.getInt("temperature1"));
        weatherEntity.setTemperature2(resultSet.getInt("temperature2"));
        weatherEntity.setTemperature3(resultSet.getInt("temperature3"));



        return weatherEntity;
    }
}
