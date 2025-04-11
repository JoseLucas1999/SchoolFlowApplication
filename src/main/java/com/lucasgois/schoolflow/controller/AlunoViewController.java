package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Aluno;
import com.lucasgois.schoolflow.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aluno")
public class AlunoViewController {
	
	//páginas HTML com Thymeleaf.

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/listar"; // Vai renderizar templates/aluno/listar.html
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/formulario"; // Vai renderizar templates/aluno/formulario.html
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        model.addAttribute("aluno", aluno);
        return "aluno/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/alunos";
    }
}
