package com.example.ForoHub.domain;

import com.example.ForoHub.Consulta.ActualizarTopico;
import com.example.ForoHub.Consulta.Curso;
import com.example.ForoHub.Consulta.DatosRegistroTopico;
import com.example.ForoHub.Consulta.Estatus;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "topicos")
@Table(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(unique = true)
    private String titulo ;

    @Column(unique = true)
    private String mensaje;

    private LocalDateTime fecha_creacion;
    private String autor;

    @Enumerated(EnumType.STRING)
    private Curso curso;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    @PrePersist
    protected void fechaCreate(){
       this.fecha_creacion = LocalDateTime.now();
    }

    public Topico(@Valid DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo() ;
        this.mensaje = datos.mensaje() ;
        this.autor = datos.autor() ;
        this.curso = datos.curso() ;
        this.estatus = datos.estatus() ;
    }

    public void actualizarInformacion(@Valid ActualizarTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null){
            this.curso = datos.curso();
        }
        if (datos.estatus() == null){
            this.setEstatus(Estatus.MODIFICADO);
        }
    }


}
