package com.example.petshop.controllers;

import com.example.petshop.models.Pet;
import com.example.petshop.services.PetServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetServices petServices;

    public PetController(PetServices petServices) {
        this.petServices = petServices;
    }

    @PostMapping
    public void cadastrarPet(@RequestBody Pet pet) {
        petServices.cadastrarPet(pet);
    }

    @GetMapping
    public List<Pet> listarPets() {
        return petServices.listarPets();
    }

    @GetMapping("/{idPet}")
    public Pet buscar(@PathVariable int idPet) {
        return petServices.buscar(idPet);
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet){
        petServices.atualizarPet(pet);
    }

    @DeleteMapping("/{idPet}")
    public String deletarPet(@PathVariable int idPet){
        return petServices.removerPet(idPet) ? "Excluido" : String.format("Pet não encontrado com o id: %d", idPet);
    }
}
