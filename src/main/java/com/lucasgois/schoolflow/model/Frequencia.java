package com.lucasgois.schoolflow.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Matricula matricula;

    private LocalDate data;

    private Boolean presente;

    // Construtores
    public Frequencia() {}

    public Frequencia(Matricula matricula, LocalDate data, Boolean presente) {
        this.matricula = matricula;
        this.data = data;
        this.presente = presente;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Matricula getMatricula() { return matricula; }
    public void setMatricula(Matricula matricula) { this.matricula = matricula; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Boolean getPresente() { return presente; }
    public void setPresente(Boolean presente) { this.presente = presente; }
}
