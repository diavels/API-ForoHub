package com.example.ForoHub.Consulta;

import jakarta.validation.constraints.NotBlank;

public record ActualizarTopico(
       @NotBlank Long id,
        String titulo,
        String mensaje,
        Curso curso,
        Estatus estatus
) {
}
