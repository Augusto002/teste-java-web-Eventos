package com.EUMESMO.teste_evento.dto;

import com.EUMESMO.teste_evento.entity.Evento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    private int identidade;

    private String nome;

    private Evento evento;

}
