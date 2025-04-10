package com.lucasgois.schoolflow.model;

import jakarta.persistence.*;

@Entity
public class Boletim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Matricula matricula;

    @ManyToOne(optional = false)
    private Disciplina disciplina;

    private Double mediaFinal;

    private Double frequenciaPercentual;

    // Construtores
    public Boletim() {}

    public Boletim(Matricula matricula, Disciplina disciplina, Double mediaFinal, Double frequenciaPercentual) {
        this.matricula = matricula;
        this.disciplina = disciplina;
        this.mediaFinal = mediaFinal;
        this.frequenciaPercentual = frequenciaPercentual;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Matricula getMatricula() { return matricula; }
    public void setMatricula(Matricula matricula) { this.matricula = matricula; }

    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }

    public Double getMediaFinal() { return mediaFinal; }
    public void setMediaFinal(Double mediaFinal) { this.mediaFinal = mediaFinal; }

    public Double getFrequenciaPercentual() { return frequenciaPercentual; }
    public void setFrequenciaPercentual(Double frequenciaPercentual) { this.frequenciaPercentual = frequenciaPercentual; }
}
