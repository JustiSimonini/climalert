package com.climalert.repositories;

import com.climalert.dtos.ClimaResumen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HistorialClimaRepository {

    private final List<ClimaResumen> historial = new ArrayList<>();

    public void guardar(ClimaResumen registro){
        historial.add(registro);
    }

    //almacenar los datos localmente para registro histórico
    public List<ClimaResumen> obtenerTodos(){
        return List.copyOf(historial);
    }

    //el sistema debe analizar la última información
    public Optional<ClimaResumen> obtenerUltimo(){
        if (historial.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(historial.get(historial.size() - 1));
    }


}
