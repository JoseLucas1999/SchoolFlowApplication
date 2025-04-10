package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Professor;
import com.lucasgois.schoolflow.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professores")
public class ProfessorViewController {

    @Autowired
    private ProfessorRepository professorRepository;

    // Lista todos os professores
    @GetMapping
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorRepository.findAll());
        return "professor/listar";
    }

    // Mostra o formulário de criação
    @GetMapping("/novo")
    public String mostrarFormularioDeCriacao(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/formulario";
    }

    // Salva o professor (novo ou editado)
    @PostMapping
    public String salvarProfessor(@ModelAttribute Professor professor) {
        professorRepository.save(professor);
        return "redirect:/professores";
    }

    // Mostra o formulário de edição
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("professor", professor);
        return "professor/formulario";
    }

    // Exclui o professor
    @GetMapping("/excluir/{id}")
    public String excluirProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
        return "redirect:/professores";
    }
}
