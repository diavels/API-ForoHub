package com.example.ForoHub.Controller;

import com.example.ForoHub.Consulta.*;
import com.example.ForoHub.Repository.TopicoRepository;
import com.example.ForoHub.domain.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/foro")
public class ForoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    //funcion para registrar en BD la informacion del topico
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos){
        topicoRepository.save(new Topico(datos));
    }

    //funcion para mostrar todos los topicos ingresados hasta el momento
    @GetMapping
    public Page<DatosTopico> mostrarTodo(@PageableDefault(size = 10, sort = {"id"}) Pageable page) {
        return topicoRepository.findAll(page)
                .map(DatosTopico::new);
    }

    //funcion para mostrar topico por id, solo si el id existe
    @GetMapping("/{id}")
    public ResponseEntity<Topico> mostrarTopico (@PathVariable Long id){
       Optional<Topico> topicoId =topicoRepository.findById(id);
        if (topicoId.isPresent()){
            return  ResponseEntity.ok(topicoId.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //nueva funicon de put
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizareTopico(@PathVariable Long id, @RequestBody ActualizarTopico datos){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()){
            Topico topico = topicoOptional.get();
            topico.actualizarInformacion(datos);
            //guardamos informacion nueva
            topicoRepository.save(topico);
            return ResponseEntity.ok(topico);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    //funcion para eliminar, de forma logica no fisica
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()){
           topicoRepository.deleteById(id);
           return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
