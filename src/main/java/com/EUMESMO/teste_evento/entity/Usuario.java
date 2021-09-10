package com.EUMESMO.teste_evento.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int identidade;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;


}
