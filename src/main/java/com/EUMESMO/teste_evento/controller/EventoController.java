package com.EUMESMO.teste_evento.controller;

import com.EUMESMO.teste_evento.Repository.EventoRepository;
import com.EUMESMO.teste_evento.Repository.UsuarioRepository;
import com.EUMESMO.teste_evento.entity.Evento;
import com.EUMESMO.teste_evento.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("api/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



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

    @DeleteMapping("/{id}")
    public String cancelarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).get();
        // Não consegui fazer

        return "";
    }

//    @PersistenceContext
//    private EntityManager manager;

    @GetMapping("/listaevento")
    public List<Evento> mostrarEvento(){
    //   TypedQuery<Evento> query =  manager.createQuery("from Evento", Evento.class );
     //   return query.getResultList();
        return  (List<Evento>) eventoRepository.findAll();

    }

    @GetMapping("/listusuario")
    public List<Usuario> mostrarUsuario(){

        return (List<Usuario>) usuarioRepository.findAll();
    }



}
