package com.example.petshop.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @PostMapping
    public String cadastrarTutor(){
        return "Cadastrado";
    }

    @GetMapping
    public String listarTutores(){
        return "Lista de tutores vazia";
    }

    @PutMapping
    public String atualizarTutor(){
        return "Atualizado";
    }

    @DeleteMapping
    public String deletarTutor(){
        return "Deletado";
    }
}
