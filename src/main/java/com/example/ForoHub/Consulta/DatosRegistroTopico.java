package com.example.ForoHub.Consulta;

public record DatosRegistroTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor,
        String curso,
        String respuesta
) {
}
