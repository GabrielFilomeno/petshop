package com.example.petshop.repositories;

import com.example.petshop.models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {

    private static List<Tutor> tutores = new ArrayList<>();
    private static int ultimoId;

    public void addTutor(Tutor tutor) {
        tutor.setIdTutor(++ultimoId);
        tutores.add(tutor);
    }

    public List<Tutor> listarTutores() {
        return tutores;
    }

    public Tutor buscar(int idTutor) {
        return tutores.stream().filter(tutor -> idTutor == tutor.getIdTutor()).findFirst().orElse(null);
    }

    public void removerTutor(Tutor tutor) {
        tutores.remove(tutor);
    }
}
