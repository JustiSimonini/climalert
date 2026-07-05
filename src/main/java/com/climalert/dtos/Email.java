package com.climalert.dtos;

import java.util.List;

public record Email(
        List<String> destinatarios,
        String remitente,
        String asunto,
        String contenido
) {
}
