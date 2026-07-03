package com.climalert.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClimaActualDTO(
        @JsonProperty("temp_c") double temperatura,
        @JsonProperty("humidity") double humedad,
        CondicionDTO condition,
        @JsonProperty("last_updated") String ultimaActualizacion
) {
}
