package com.climalert.services;

import com.climalert.config.AlertaProperties;
import com.climalert.dtos.ClimaResumen;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacionesService {
    private final JavaMailSender mailSender;
    private final AlertaProperties alertaProperties;

    public NotificacionesService(AlertaProperties alertaProperties, JavaMailSender mailSender) {
        this.alertaProperties = alertaProperties;
        this.mailSender = mailSender;
    }

    public void enviarAlerta(ClimaResumen registro){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(alertaProperties.getDestinatarios().toArray(new String[0]));
        mensaje.setSubject("Alerta climática detectada");
        mensaje.setText(construirCuerpo(registro));

        mailSender.send(mensaje);
    }

    private String construirCuerpo(ClimaResumen registro){
        return """
                Se ha detectado una condición climática de alerta.
                
                Detalle del clima:
                - Temperatura: %.1f °C
                - Humedad: %.1f %%
                - Condición: %s
                - Fecha y hora: %s
                """.formatted(
                        registro.temperatura(),
                registro.humedad(),
                registro.condicion(),
                registro.fechaHora()
        );
    }
}
