/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.model.bl;

import com.apexcoders.entities.UniversityCourses;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JREscert
 */
@Stateless
public class UniversityCoursesFacade extends AbstractFacade<UniversityCourses> implements UniversityCoursesFacadeLocal {

    @PersistenceContext(unitName = "StudentPathGuideWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UniversityCoursesFacade() {
        super(UniversityCourses.class);
    }

    @Override
    public List<UniversityCourses> findByUniversity(Long universityId) {
   
        Query qu = em.createQuery("SELECT uc FROM UniversityCourses uc "
                + "WHERE uc.university.id = :id");
        
        qu.setParameter("id", universityId);
        
        return qu.getResultList();
    }
    
}
