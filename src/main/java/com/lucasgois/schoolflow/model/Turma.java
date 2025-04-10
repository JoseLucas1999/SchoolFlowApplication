package com.lucasgois.schoolflow.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String anoLetivo;
    
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;
    
    @OneToMany(mappedBy = "turma")
    private List<TurmaDisciplina> disciplinas;


    @ManyToMany
    @JoinTable(
        name = "turma_disciplinas",
        joinColumns = @JoinColumn(name = "turma_id"),
        inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplina = new HashSet<>();

    // Construtores
    public Turma() {}

    public Turma(Long id, String nome, String anoLetivo) {
        this.id = id;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAnoLetivo() { return anoLetivo; }
    public void setAnoLetivo(String anoLetivo) { this.anoLetivo = anoLetivo; }

    public Set<Disciplina> getDisciplinas() { return disciplina; }
    public void setDisciplinas(Set<Disciplina> disciplina) { this.disciplina = disciplina; }
}
