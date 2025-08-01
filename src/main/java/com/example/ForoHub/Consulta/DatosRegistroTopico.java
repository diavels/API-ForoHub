package com.example.ForoHub.Consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroTopico(
       @NotBlank String titulo,
       @NotBlank String mensaje,
        String fechaCreacion,
       @NotNull Estatus estatus,
        String autor,
       @NotNull Curso curso
) {
}
