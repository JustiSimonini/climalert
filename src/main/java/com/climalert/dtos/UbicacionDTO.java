package com.climalert.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //ignora todos los atributos que no me interesan
public record UbicacionDTO(
        String name,
        String region,
        String country,
        String localtime
) {
}
