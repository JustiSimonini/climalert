package com.climalert.services;

import com.climalert.config.AlertaProperties;
import com.climalert.dtos.ClimaResumen;
import org.springframework.stereotype.Service;

//solamente consideraremos como “alerta” a una temperatura mayor a
//35° y una humedad superior a 60%.
@Service
public class AlertaService {

    private final AlertaProperties alertaProperties;

    public AlertaService(AlertaProperties alertaProperties) {
        this.alertaProperties = alertaProperties;
    }

    public boolean esAlerta(ClimaResumen registro){
        return registro.temperatura() > alertaProperties.getLimiteTemperatura()
                && registro.humedad() > alertaProperties.getLimiteHumedad();
    }
}
