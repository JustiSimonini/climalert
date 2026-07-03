package com.climalert;

import com.climalert.config.AlertaProperties;
import com.climalert.config.WeatherApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties({WeatherApiProperties.class, AlertaProperties.class})
@EnableScheduling
public class ClimalertApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimalertApplication.class, args);
    }

}
