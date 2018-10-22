/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.shelter.endpoint;

import com.aeg.shelter.dto.AnimalDTO;
import com.aeg.shelter.dto.AnimalListDTO;
import com.aeg.shelter.facade.AnimalFacadeLocal;
import com.aeg.shelter.model.Animal;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author aegid
 */
@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

public class AnimalEndpoint {

    @Inject
    private AnimalFacadeLocal animalFacade;

    public String createAnimal(AnimalDTO animalDTO) {
        if (animalDTO == null) {
            throw new IllegalArgumentException();
        }
        Animal animal = new Animal(animalDTO.getName(), animalDTO.getSpecies(), animalDTO.getAge(), animalDTO.getSex(), animalDTO.getDescription());
        animalFacade.create(animal);
        return "animalCreateConfirmation.xhtml";
    }

    public List<Animal> listAllAnimal(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAll();
        return animalListDTO.animalList;
    }

    public List<Animal> listAllCats(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAnimalBySpecies("Kot");
        return animalListDTO.animalList;
    }

    public List<Animal> listAllDogs(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAnimalBySpecies("Pies");
        return animalListDTO.animalList;
    }

    public List<Animal> listAllRabbits(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAnimalBySpecies("Królik");
        return animalListDTO.animalList;
    }

    public List<Animal> listAllGuineaPigs(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAnimalBySpecies("Świnka morska");
        return animalListDTO.animalList;
    }

    public List<Animal> listAllOtherAnimal(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAnimalBySpecies("Inne (proszę podać w opisie)");
        return animalListDTO.animalList;
    }

    public List<Animal> listAllBoys(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAnimalBySex("Męska");
        return animalListDTO.animalList;
    }

    public List<Animal> listAllGirls(AnimalListDTO animalListDTO) {
        animalListDTO.animalList = animalFacade.findAnimalBySex("Żeńska");
        return animalListDTO.animalList;
    }

    public void deleteAnimal(AnimalDTO animalDTO) {
        animalFacade.remove(animalDTO.getAnimalToEdit());
    }
    
    public void editAnimal(AnimalDTO animalDTO) {
        animalFacade.edit(animalDTO.getAnimalToEdit());
               
    }

}
