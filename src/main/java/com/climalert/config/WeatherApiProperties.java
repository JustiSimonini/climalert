package com.climalert.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

//Le indica a Spring Boot que lea del archivo de config todas las
//propiedades que empiecen con el prefijo weather-api
@ConfigurationProperties(prefix = "weather-api")
@Data
public class WeatherApiProperties {
    private String baseUrl;
    private String key;
    private String location;

}
