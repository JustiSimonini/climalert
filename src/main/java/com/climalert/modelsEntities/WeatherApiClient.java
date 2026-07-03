package com.climalert.modelsEntities;

import com.climalert.config.WeatherApiProperties;
import com.climalert.dtos.RespuestaClimaApiDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherApiClient {
    private final RestTemplate restTemplate;
    private final WeatherApiProperties properties;

    public WeatherApiClient(WeatherApiProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    public RespuestaClimaApiDTO obtenerClimaActual(){
        URI uri = UriComponentsBuilder
                .fromUriString(properties.getBaseUrl())
                .path("/current.json")
                .queryParam("key", properties.getKey())
                .queryParam("q", properties.getLocation())
                .build()
                .toUri();

        return restTemplate.getForObject(uri, RespuestaClimaApiDTO.class);
    }


}
