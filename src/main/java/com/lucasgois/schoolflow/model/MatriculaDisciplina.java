package com.lucasgois.schoolflow.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MatriculaDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Matricula matricula;

    @ManyToOne
    private Disciplina disciplina;

    @Column
    private Double mediaFinal;

    @Column
    private Double frequencia;

    @Enumerated(EnumType.STRING)
    private StatusDisciplina status;

    @Column(length = 500)
    private String observacoes;

    @Column
    private LocalDate dataConclusao;

    public MatriculaDisciplina() {}

    public MatriculaDisciplina(Long id, Matricula matricula, Disciplina disciplina, Double mediaFinal, Double frequencia, StatusDisciplina status, String observacoes, LocalDate dataConclusao) {
        this.id = id;
        this.matricula = matricula;
        this.disciplina = disciplina;
        this.mediaFinal = mediaFinal;
        this.frequencia = frequencia;
        this.status = status;
        this.observacoes = observacoes;
        this.dataConclusao = dataConclusao;
    }

    // Getters e setters omitidos por brevidade
}
