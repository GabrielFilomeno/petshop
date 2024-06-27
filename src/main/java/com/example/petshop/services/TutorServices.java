package com.example.petshop.services;

import com.example.petshop.models.Tutor;
import com.example.petshop.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServices {

    private TutorRepository tutorRepository;

    public TutorServices(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public void cadastrarTutor(Tutor tutor) {
        tutorRepository.addTutor(tutor);
    }

    public List<Tutor> listarTutores() {
        return tutorRepository.listarTutores();
    }

    public Tutor buscar(int idTutor) {
        return tutorRepository.buscar(idTutor);
    }

    public boolean removerTutor(int idTutor) {
        var tutorRemover = tutorRepository.buscar(idTutor);

        if (tutorRemover != null) {
            tutorRepository.removerTutor(tutorRemover);
            return true;
        }

        return false;
    }

    public boolean atualizarTutor(Tutor tutor) {
        var tutorAtualizar = tutorRepository.buscar(tutor.getIdTutor());

        if (tutorAtualizar != null) {
            tutorAtualizar.setNomeTutor(tutor.getNomeTutor());
            tutorAtualizar.setIdade(tutor.getIdade());
            tutorAtualizar.setEndereco(tutor.getEndereco());

            return true;
        }

        return false;
    }
}

