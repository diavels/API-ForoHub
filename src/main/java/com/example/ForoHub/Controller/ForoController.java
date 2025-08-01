package com.example.ForoHub.Controller;

import com.example.ForoHub.Consulta.DatosRegistroTopico;
import com.example.ForoHub.Repository.TopicoRepository;
import com.example.ForoHub.Service.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public Page <Topico> mostrarTodo (@PageableDefault (size = 10) Pageable page) {
        return TopicoRepository.findall(page)
            .map(DatosTopico::new);
}

