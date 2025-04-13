package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Turma;
import com.lucasgois.schoolflow.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Turma> buscarPorId(@PathVariable Long id) {
        return turmaRepository.findById(id);
    }

    @PostMapping
    public Turma criar(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma atualizar(@PathVariable Long id, @RequestBody Turma atualizada) {
        return turmaRepository.findById(id).map(t -> {
            t.setNome(atualizada.getNome());
            t.setAnoLetivo(atualizada.getAnoLetivo());
            return turmaRepository.save(t);
        }).orElseGet(() -> {
            atualizada.setId(id);
            return turmaRepository.save(atualizada);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        turmaRepository.deleteById(id);
    }
}
