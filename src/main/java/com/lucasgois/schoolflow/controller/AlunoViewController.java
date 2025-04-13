package com.lucasgois.schoolflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucasgois.schoolflow.model.Aluno;
import com.lucasgois.schoolflow.repository.AlunoRepository;
import com.lucasgois.schoolflow.repository.TurmaRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoViewController {
	
	//páginas HTML com Thymeleaf.

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    // Lista todos os professores
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/listar"; // Vai renderizar templates/aluno/listar.html
    }

    // Mostra o formulário de criação
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("turmas", turmaRepository.findAll()); // tras as turmas
        return "aluno/formulario"; // Vai renderizar templates/aluno/formulario.html
    }

    // Salva o aluno (novo ou editado)
    @PostMapping
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/aluno/listar";
    }

    // Mostra o formulário de criação
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        model.addAttribute("aluno", aluno);
        model.addAttribute("turmas", turmaRepository.findAll()); // tras as turmas
        return "aluno/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/aluno/listar";
    }
}
