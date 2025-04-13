package com.lucasgois.schoolflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lucasgois.schoolflow.model.Professor;
import com.lucasgois.schoolflow.repository.DisciplinaRepository;
import com.lucasgois.schoolflow.repository.ProfessorRepository;

@Controller
@RequestMapping("/professor")
public class ProfessorViewController {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // Lista todos os professores
    @GetMapping("/listar")
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorRepository.findAll());
        return "professor/listar";
    }

    // Mostra o formulário de criação
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("professor", new Professor());
        model.addAttribute("discip", disciplinaRepository.findAll()); // tras as turmas
        return "professor/formulario"; // abre o formulario professor
    }

    // Salva o professor (novo ou editado)
    @PostMapping
    public String salvarProfessor(@ModelAttribute Professor professor) {
        professorRepository.save(professor);
        return "redirect:/professor/listar"; // salva o que estiver em formulario professor
    }

    // Mostra o formulário de edição
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("professor", professor);
        model.addAttribute("discip", disciplinaRepository.findAll()); // tras as turmas
        return "professor/formulario"; // abre o formulario professor
    }

    // Exclui o professor
    @GetMapping("/excluir/{id}")
    public String deletar(@PathVariable Long id) {
        professorRepository.deleteById(id);
        return "redirect:/professor/listar";
    }
}
