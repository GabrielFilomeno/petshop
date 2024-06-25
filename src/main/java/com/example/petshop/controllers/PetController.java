package com.example.petshop.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {

    @PostMapping
    public String cadastrarPet() {
        return "Cadastrado";
    }

    @GetMapping
    public String listarPets() {
        return "Lista de pets vazia";
    }

    @PutMapping
    public String atualizarPet(){
        return "Pet atualizado";
    }

    @DeleteMapping
    public String deletarPet(){
        return "Pet deletado";
    }
}
