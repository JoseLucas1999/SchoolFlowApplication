package com.lucasgois.schoolflow.model;

import jakarta.persistence.*;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true, nullable = false)
    private String telefone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    // Construtores
    public Professor() {}

    public Professor(Long id, String nome, String email, Disciplina disciplina) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        //this.disciplina = disciplina;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}

	public String getTelefone() {return telefone;}
	public void setTelefone(String telefone) {this.telefone = telefone;}

	public Disciplina getDisciplina() {return disciplina;}
	public void setDisciplina(Disciplina disciplina) {this.disciplina = disciplina;}
	
	
}
