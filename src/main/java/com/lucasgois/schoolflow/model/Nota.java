package com.lucasgois.schoolflow.model;

import jakarta.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Matricula matricula;

    private String descricao; // Ex: "Prova 1", "Trabalho Final"
    private Double valor;

    // Construtores
    public Nota() {}

    public Nota(Matricula matricula, String descricao, Double valor) {
        this.matricula = matricula;
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Matricula getMatricula() { return matricula; }
    public void setMatricula(Matricula matricula) { this.matricula = matricula; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}
