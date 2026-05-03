/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.model.bl;

import com.apexcoders.entities.University;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JREscert
 */
@Stateless
public class UniversityFacade extends AbstractFacade<University> implements UniversityFacadeLocal {

    @PersistenceContext(unitName = "StudentPathGuideWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UniversityFacade() {
        super(University.class);
    }

    @Override
    public University findByNameOrAbbreviation(String input) {
       
        Query qu = em.createQuery("SELECT u FROM University u " +
                "WHERE u.universityName = :input " +
                "OR u.universityAbbreviation = :input");
        
        qu.setParameter("input", input);
        
        University university = null;
        
        try {
            university = (University)qu.getSingleResult();
        } catch (Exception e) {
            university = null;
        }
        
        return university;
    }
    
}
