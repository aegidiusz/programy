/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.shelter.facade;

import com.aeg.shelter.model.Animal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aegid
 */
@Local
public interface AnimalFacadeLocal {

    void create(Animal animal);

    void edit(Animal animal);

    void remove(Animal animal);

    Animal find(Object id);

    List<Animal> findAll();

    List<Animal> findAnimalBySpecies(String species);

    List<Animal> findAnimalBySex(String sex);

    List<Animal> findRange(int[] range);

    int count();

}
