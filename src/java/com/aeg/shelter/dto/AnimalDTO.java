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
 * @author aegid
 */
public class AnimalDTO {

    private String name;
    private String species;
    private int age;
    private String sex;
    private String description;
    public List<Animal> animalList;
    private Long id;
    private Animal animalToEdit;
    private Animal editedAnimal;

    public AnimalDTO(String name, String species, int age, String sex, String description) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.description = description;
    }

    public AnimalDTO(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public Long getId() {
        return id;
    }

    public Animal getAnimalToEdit() {
        return animalToEdit;
    }

    public void setAnimalToEdit(Animal animalToEdit) {
        this.animalToEdit = animalToEdit;
    }

    public Animal getEditedAnimal() {
        return editedAnimal;
    }

    public void setEditedAnimal(Animal editedAnimal) {
        this.editedAnimal = editedAnimal;
    }
    
    

}
