package com.example.petshop.repositories;

import com.example.petshop.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {
    private TutorRepository tutorRepository;

        private static List<Pet> pets = new ArrayList<>();
        private static int ultimoId;

        public PetRepository(TutorRepository tutorRepository) {
            this.tutorRepository = tutorRepository;
        }

        public void addPet(Pet pet) {
            pet.setIdPet(++ultimoId);
            var tutor = tutorRepository.buscar(pet.getIdTutor());
            pet.setTutor(tutor);
            pets.add(pet);
        }

        public List<Pet> listarPets() {
            return pets;
        }

        public Pet buscar(int idPet) {
            return pets.stream().filter(pet -> idPet == pet.getIdPet()).findFirst().orElse(null);
        }

        public void removerPet(Pet pet) {
            pets.remove(pet);
        }

}
