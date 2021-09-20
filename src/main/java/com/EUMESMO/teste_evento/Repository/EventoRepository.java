package com.EUMESMO.teste_evento.Repository;

import com.EUMESMO.teste_evento.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends JpaRepository<Evento,Long> {



}
