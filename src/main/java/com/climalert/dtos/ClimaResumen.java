package com.climalert.dtos;

import java.time.LocalDateTime;

public record ClimaResumen(
        double temperatura,
        double humedad,
        String condicion,
        LocalDateTime fechaHora
) {
}
