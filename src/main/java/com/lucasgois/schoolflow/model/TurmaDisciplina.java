package com.lucasgois.schoolflow.model;

import jakarta.persistence.*;

@Entity
public class TurmaDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Turma turma;

    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public TurmaDisciplina() {}

    public TurmaDisciplina(Turma turma, Disciplina disciplina) {
        this.turma = turma;
        this.disciplina = disciplina;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }

    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
}

/**
 * Entidade intermediária que representa o relacionamento entre Turma e Disciplina.
 * Permite associar múltiplas disciplinas a uma turma e vice-versa.
 * Essa abordagem facilita a adição de informações extras no futuro,
 * como professor responsável, carga horária, ou ano letivo específico.
 */
