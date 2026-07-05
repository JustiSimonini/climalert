package com.climalert.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix="alerta")
@Data
public class AlertaProperties {
    private double limiteTemperatura;
    private double limiteHumedad;
    private List<String> destinatarios;
    private String remitente;
}
