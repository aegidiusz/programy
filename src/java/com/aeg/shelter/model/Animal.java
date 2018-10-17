/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.shelter.model;

import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aegid
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Animal.findBySpecies", query = "SELECT a FROM Animal a WHERE a.species = :species")
    ,
    @NamedQuery(name = "Animal.findBySex", query = "SELECT a FROM Animal a WHERE a.sex = :sex")

})
public class Animal implements Serializable {

    public Animal(String name, String species, int age, String sex, String description) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.description = description;
    }

    public Animal() {
    }

    private static final long serialVersionUID = 1L;
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    @NotNull
    @Size(min = 3, max = 20)
    //@Column(name = "name", length = 20, nullable = false, updatable = true)
    private String name;
    
    @NotNull
    @Size(min = 3, max = 20)
    //@Column(name = "species", nullable = false, updatable = false)
    private String species;
    
    //@Column(name = "age", nullable = true, updatable = true)
    private int age;
    
    @NotNull
    @Size(min = 5, max = 6)
    //@Column(name = "sex", length = 6, nullable = false, updatable = false)
    private String sex;
    
    @Size(min = 5, max = 200)
    //@Column(name = "description", length = 200, nullable = true, updatable = true)
    private String description;

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + '}';
    }

}
