/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.shelter.dto;

import com.aeg.shelter.model.Animal;
import java.util.List;

/**
 *
 * @author my8
 */
public class AnimalListDTO {
    
     public List<Animal> animalList;
     
       
     public AnimalListDTO(List<Animal> animalList) {
        this.animalList = animalList;
    }
     
      public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
    
}
