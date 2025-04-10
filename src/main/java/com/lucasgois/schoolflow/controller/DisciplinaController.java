package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Disciplina;
import com.lucasgois.schoolflow.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Disciplina> buscarPorId(@PathVariable Long id) {
        return disciplinaRepository.findById(id);
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @RequestBody Disciplina atualizada) {
        return disciplinaRepository.findById(id).map(d -> {
            d.setNome(atualizada.getNome());
            d.setCargaHoraria(atualizada.getCargaHoraria());
            d.setDescricao(atualizada.getDescricao());
            return disciplinaRepository.save(d);
        }).orElseGet(() -> {
            atualizada.setId(id);
            return disciplinaRepository.save(atualizada);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
    }
    
    @GetMapping("/professor/{professorId}")
    public List<Disciplina> listarPorProfessor(@PathVariable Long professorId) {
        return disciplinaRepository.findByProfessorId(professorId);
    }

}
