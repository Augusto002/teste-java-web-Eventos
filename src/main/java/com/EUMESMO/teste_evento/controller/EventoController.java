package com.EUMESMO.teste_evento.controller;

import com.EUMESMO.teste_evento.Repository.EventoRepository;
import com.EUMESMO.teste_evento.Repository.UsuarioRepository;
import com.EUMESMO.teste_evento.dto.UsuarioDTO;
import com.EUMESMO.teste_evento.entity.Evento;
import com.EUMESMO.teste_evento.entity.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.*;

@RestController
@RequestMapping("api/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public String inserirEvento(@RequestBody Evento evento){
     Evento evento1 = eventoRepository.save(evento);
     String messagem = "Evento criado com sucesso ID: " + evento1.getId();
     return messagem;
    }

    @PostMapping("/{id}")
    public String inserirUsuarioEvento(@RequestBody Usuario usuario , @PathVariable Long id){
        Evento eventoSave = eventoRepository.findById(id).get();
        usuario.setEvento(eventoSave);
        Usuario usuario1 = usuarioRepository.save(usuario);

        String messagem = "Usuario Criado id:(" + usuario.getId() + ") No Evento: ("
                + usuario.getEvento().getNome()+")";
        return messagem;
    }

    @DeleteMapping("/usuarioDel/{id}")
    public String deletarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);

        return "Usuario DELETADO";
    }

    @GetMapping("/listaevento")
    public List<Evento> mostrarEvento(){
        List<Evento> all = eventoRepository.findAll();
        List<Evento> eventStream = all.stream().map(it -> objectMapper.convertValue(it, Evento.class))
                .collect(Collectors.toList());

        return  eventStream;

    }

    @GetMapping("/listusuario")
    public List<Usuario> mostrarUsuario(){
       List<Usuario> all = usuarioRepository.findAll();
       List<Usuario> usuarioStream = all.stream().map(it -> objectMapper.convertValue(it, Usuario.class))
               .collect(Collectors.toList());

        return usuarioStream;
    }



}
