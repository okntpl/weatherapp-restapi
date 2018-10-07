package com.okan.Weather;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WeatherDao  {
    @Autowired
    JdbcTemplate jdbcTemplate;


public List<WeatherEntity> findAll()
{
    List<WeatherEntity> weatherEntities = jdbcTemplate.query("select * from weather ",new WeatherRowMapper());
    return weatherEntities;
}
public WeatherEntity updateByName(String distinctName, int temp1,int temp2,int temp3)
{
    String updateQuery = "update weather set temperature1 = ? where distinctName = ?";
    jdbcTemplate.update(updateQuery, temp1,distinctName);
    String updateQuery1 = "update weather set temperature2 = ? where distinctName = ?";
    jdbcTemplate.update(updateQuery1, temp2,distinctName);
    String updateQuery2 = "update weather set temperature3 = ? where distinctName = ?";
    jdbcTemplate.update(updateQuery2, temp3,distinctName);

    WeatherEntity weatherEntity=jdbcTemplate.queryForObject("select * from weather where distinctName=?",new Object[] {distinctName}, new WeatherRowMapper());
    return weatherEntity;
}


}
