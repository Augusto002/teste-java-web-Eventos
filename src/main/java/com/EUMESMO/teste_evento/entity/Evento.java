package com.EUMESMO.teste_evento.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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



    @OneToMany(mappedBy = "evento", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Usuario> usuarios;

}
