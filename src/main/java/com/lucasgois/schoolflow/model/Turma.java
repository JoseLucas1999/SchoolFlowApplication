package com.lucasgois.schoolflow.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    // Construtores
    public Turma() {}

    public Turma(Long id, String nome, String anoLetivo) {
        this.id = id;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma)) return false;
        Turma turma = (Turma) o;
        return id != null && id.equals(turma.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAnoLetivo() { return anoLetivo; }
    public void setAnoLetivo(String anoLetivo) { this.anoLetivo = anoLetivo; }

}
