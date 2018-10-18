/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.shelter.web;

import com.aeg.shelter.dto.AnimalDTO;
import com.aeg.shelter.endpoint.AnimalEndpoint;
import com.aeg.shelter.model.Animal;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;

/**
 *
 * @author aegid
 */
@Named
@SessionScoped
public class AnimalBean implements Serializable {

    /**
     * Creates a new instance of AnimalBean
     */
    public AnimalBean() {
    }
    
    @Inject
    private AnimalEndpoint animalEndpoint;

    private List<Animal> animalList;

    private AnimalDTO animalDTO = new AnimalDTO("Wprowadź imię", "", 0, "", "Wpisz opis");

    public AnimalDTO getAnimalDTO() {
        return animalDTO;
    }

    public void setAnimalDTO(AnimalDTO animalDTO) {
        this.animalDTO = animalDTO;
    }

    public String saveAnimal() {
        animalEndpoint.createAnimal(animalDTO);
        return "animalCreateConfirmation.xhtml";
    }

    public String listAllAnimal() {
        animalEndpoint.listAllAnimal(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String listAllCats() {
        animalEndpoint.listAllCats(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String listAllDogs() {
        animalEndpoint.listAllDogs(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String listAllGuineaPigs() {
        animalEndpoint.listAllGuineaPigs(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String listAllRabbits() {
        animalEndpoint.listAllRabbits(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String listAllOtherAnimals() {
        animalEndpoint.listAllOtherAnimal(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String listAllBoys() {
        animalEndpoint.listAllBoys(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String listAllGirls() {
        animalEndpoint.listAllGirls(animalDTO);
        return "/listAnimal.xhtml";
    }

    public String deleteAnimal(Animal animal) {
        animalEndpoint.deleteAnimal(animalDTO);
        return "deletedAnimalInfo.xhtml";

    }
    
    /*Problem: metoda editAnimal() działa (aktualizuje pozycję w bazie danych) dopiero po drugim wciśnięciu 
    przycisku, przy czym także dane które mają być zmienione, muszą być wpisane dwukrotnie.
    Na stronie z potwierdzeniem są wyświetlane dane ostatnio dodanego zwierzęcia, a nie
    tego, które było edytowane. W przypadku, gdy po uruchomieniu aplikacji nie dodano żadnego
    zwierzęcia, nie jest wyświetlane nic (ani zaktualizowane zwierzę, ani zwierzę przed
    aktualizacją danych). Zaktualizowane dane widać od razu po kliknięciu linku "pokaż zwierzęta",
    lista "administracyjna" jest aktualizowana dopiero po tym (lista dostępna po 
    kliknięcie linku zwierzęta - zarządzanie bezpośrednio po aktualizacji danych zwierzęcia 
    nie odzwierciedla wprowadzonych zmian, widać je dopiero po kliknięciu kolejno 
    Pokaż zwierzęta / Powrót do głównej / Administracja / Zwierzęta - zarządzanie. Dotyczy to także 
    aktualizacji listy po usunięciu zwierzęcia). Dlaczego?
    */
    
    public String editAnimal(Animal animal) {
        animalEndpoint.editAnimal(animalDTO);
        return "updateAnimalConfirmation.xhtml";
  }

}
