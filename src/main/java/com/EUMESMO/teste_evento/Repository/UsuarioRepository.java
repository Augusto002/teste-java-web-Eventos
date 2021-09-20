package com.EUMESMO.teste_evento.Repository;

import com.EUMESMO.teste_evento.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
