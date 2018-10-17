/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.shelter.endpoint;

import com.aeg.shelter.dto.AnimalDTO;
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

    public List<Animal> listAllAnimal(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAll();
        return animalDTO.animalList;
    }

    public List<Animal> listAllCats(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAnimalBySpecies("Kot");
        return animalDTO.animalList;
    }

    public List<Animal> listAllDogs(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAnimalBySpecies("Pies");
        return animalDTO.animalList;
    }

    public List<Animal> listAllRabbits(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAnimalBySpecies("Królik");
        return animalDTO.animalList;
    }

    public List<Animal> listAllGuineaPigs(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAnimalBySpecies("Świnka morska");
        return animalDTO.animalList;
    }

    public List<Animal> listAllOtherAnimal(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAnimalBySpecies("Inne (proszę podać w opisie)");
        return animalDTO.animalList;
    }

    public List<Animal> listAllBoys(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAnimalBySex("Męska");
        return animalDTO.animalList;
    }

    public List<Animal> listAllGirls(AnimalDTO animalDTO) {
        animalDTO.animalList = animalFacade.findAnimalBySex("Żeńska");
        return animalDTO.animalList;
    }

    public void deleteAnimal(AnimalDTO animalDTO) {
        animalFacade.remove(animalDTO.getAnimalToEdit());
    }
    
    public void editAnimal(AnimalDTO animalDTO) {
        animalFacade.edit(animalDTO.getAnimalToEdit());                       
    }

}
