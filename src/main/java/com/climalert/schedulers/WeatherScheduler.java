package com.climalert.schedulers;

import com.climalert.dtos.ClimaResumen;
import com.climalert.dtos.WeatherApiResponseDTO;
import com.climalert.modelsEntities.WeatherApiClient;
import com.climalert.repositories.HistorialClimaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WeatherScheduler {

    private final WeatherApiClient weatherApiClient;
    private final HistorialClimaRepository historialClimaRepository;

    public WeatherScheduler(HistorialClimaRepository historialClimaRepository, WeatherApiClient weatherApiClient) {
        this.historialClimaRepository = historialClimaRepository;
        this.weatherApiClient = weatherApiClient;
    }

    //cada 5 minutos el sistema debe obtener los datos actuales y almacenarlos localmente
    //5 minutos = 300000ms
    @Scheduled(fixedDelay = 300000, initialDelay = 0)
    public void obtenerYGuardarClima(){
        WeatherApiResponseDTO respuesta = weatherApiClient.obtenerClimaActual();

        ClimaResumen registro = new ClimaResumen(
                respuesta.current().temperatura(),
                respuesta.current().humedad(),
                respuesta.current().condition().text(),
                LocalDateTime.now()
        );

        historialClimaRepository.guardar(registro);
    }
}
