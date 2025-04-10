package com.lucasgois.schoolflow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasgois.schoolflow.model.Disciplina;
import com.lucasgois.schoolflow.model.Professor;
import com.lucasgois.schoolflow.repository.ProfessorRepository;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Professor> buscarPorId(@PathVariable Long id) {
        return professorRepository.findById(id);
    }

    @PostMapping
    public Professor criar(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody Professor atualizado) {
        return professorRepository.findById(id).map(prof -> {
            prof.setNome(atualizado.getNome());
            prof.setEmail(atualizado.getEmail());
            prof.setEspecializacao(atualizado.getEspecializacao());
            return professorRepository.save(prof);
        }).orElseGet(() -> {
            atualizado.setId(id);
            return professorRepository.save(atualizado);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }
    
}
