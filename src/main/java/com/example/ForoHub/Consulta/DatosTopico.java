package com.example.ForoHub.Consulta;

import com.example.ForoHub.domain.Topico;

import java.time.LocalDateTime;

public record DatosTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion
) {
    public DatosTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion()
        );
    }
}

