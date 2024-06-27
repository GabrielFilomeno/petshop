package com.example.petshop.services;

import com.example.petshop.models.Pet;
import com.example.petshop.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServices {

    private PetRepository petRepository;

    public PetServices(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public void cadastrarPet(Pet pet){
        petRepository.addPet(pet);
    }

    public List<Pet> listarPets() {
        return petRepository.listarPets();
    }

    public Pet buscar(int idPet) {
        return petRepository.buscar(idPet);
    }

    public boolean removerPet(int idPet) {
        var petRemover = petRepository.buscar(idPet);

        if (petRemover != null) {
            petRepository.removerPet(petRemover);
            return true;
        }

        return false;
    }

    public boolean atualizarPet(Pet pet) {
        var petAtualizar = petRepository.buscar(pet.getIdPet());
        if (petAtualizar != null) {
            petAtualizar.setNomePet(pet.getNomePet());
            petAtualizar.setRaca(pet.getRaca());
            petAtualizar.setPeso(pet.getPeso());
            petAtualizar.setAltura(pet.getAltura());
            petAtualizar.setDataNascimento(pet.getDataNascimento());
            petAtualizar.setEspecie(pet.getEspecie());
            return true;
        }

        return false;
    }
}
