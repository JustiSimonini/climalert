package com.climalert.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//representa la respuesta completa del endpoint /current.json de la weather api
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherApiResponseDTO(
        UbicacionDTO location,
        ClimaActualDTO current
) {
}
