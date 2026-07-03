package com.climalert.schedulers;

import com.climalert.dtos.ClimaActualDTO;
import com.climalert.dtos.ClimaResumen;
import com.climalert.repositories.HistorialClimaRepository;
import com.climalert.services.AlertaService;
import com.climalert.services.NotificacionesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

//Cada 1 minuto, el Sistema deberá analizar la última información disponible del clima.
@Component
public class AlertaScheduler {
    private final HistorialClimaRepository historialClimaRepository;
    private final AlertaService alertaService;
    private final NotificacionesService notificacionesService;

    public AlertaScheduler(AlertaService alertaService, HistorialClimaRepository historialClimaRepository, NotificacionesService notificacionesService) {
        this.alertaService = alertaService;
        this.historialClimaRepository = historialClimaRepository;
        this.notificacionesService = notificacionesService;
    }

    @Scheduled(fixedDelay = 60000)
    public void analizarUltimoClima(){
        Optional<ClimaResumen> ultimoRegistro = historialClimaRepository.obtenerUltimo();

        if(ultimoRegistro.isEmpty()){
            return; //si todavia no hay registro
        }

        ClimaResumen registro = ultimoRegistro.get();

        if(alertaService.esAlerta(registro)) {
            notificacionesService.enviarAlerta(registro);
        }
    }
}
