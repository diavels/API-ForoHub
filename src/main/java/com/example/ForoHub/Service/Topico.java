package com.example.ForoHub.Service;

import com.example.ForoHub.Consulta.Curso;
import com.example.ForoHub.Consulta.DatosRegistroTopico;
import com.example.ForoHub.Consulta.Estatus;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "topicos")
@Table(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String titulo ;
    private String mensaje;
    private String fechaCreacion;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    public Topico(@Valid DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo() ;
        this.mensaje = datos.mensaje() ;
        this.fechaCreacion = datos.fechaCreacion() ;
        this.autor = datos.autor() ;
        this.curso = datos.curso() ;
        this.estatus = datos.estatus() ;
    }
}

