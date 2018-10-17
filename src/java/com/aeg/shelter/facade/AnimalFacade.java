/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeg.shelter.facade;

import com.aeg.shelter.model.Animal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aegid
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class AnimalFacade extends AbstractFacade<Animal> implements AnimalFacadeLocal {

    @PersistenceContext(unitName = "MyShelterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnimalFacade() {
        super(Animal.class);
    }

    @Override
    public List<Animal> findAnimalBySpecies(String species) {
        Query query = em.createNamedQuery("Animal.findBySpecies");
        query.setParameter("species", species);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Animal> findAnimalBySex(String sex) {
        Query query = em.createNamedQuery("Animal.findBySex");
        query.setParameter("sex", sex);
        List resultList = query.getResultList();
        return resultList;
    }

}
