package com.example.petshop.controllers;

import com.example.petshop.models.Tutor;
import com.example.petshop.services.TutorServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    private TutorServices tutorServices;

    public TutorController(TutorServices tutorServices) {
        this.tutorServices = tutorServices;
    }

    @PostMapping
    public void cadastrarTutor(@RequestBody Tutor tutor){
        tutorServices.cadastrarTutor(tutor);
    }

    @GetMapping
    public List<Tutor> listarTutores(){
        return tutorServices.listarTutores();
    }

    @GetMapping("/{idTutor}")
    public Tutor buscar(@PathVariable int idTutor){
        return tutorServices.buscar(idTutor);
    }

    @PutMapping
    public void atualizarTutor(@RequestBody Tutor tutor){
        tutorServices.atualizarTutor(tutor);
    }

    @DeleteMapping("/{idTutor}")
    public String deletarTutor(@PathVariable int idTutor){
        return tutorServices.removerTutor(idTutor) ? "Excluido" : String.format("Tutor não encontrado com o id: %d", idTutor);
    }
}
