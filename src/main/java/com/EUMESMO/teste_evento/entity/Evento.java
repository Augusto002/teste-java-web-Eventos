package com.EUMESMO.teste_evento.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int vagas;

    @Column(nullable = false)
    private String dataInicio;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String dataFim;

    @Column(nullable = false)
    private String horarioFim;


   /* @JoinTable(name = "evento_usuario",
             joinColumns = @JoinColumn(name = "evento_id"),
             inverseJoinColumns = @JoinColumn(name = "alunos_id")  )*/
    @OneToMany(mappedBy = "evento"/*, cascade=CascadeType.ALL, orphanRemoval=true*/)
    private List<Usuario> usuarios;

}
