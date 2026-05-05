/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.model.bl;

import com.apexcoders.entities.Course;
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
public class CourseFacade extends AbstractFacade<Course> implements CourseFacadeLocal {

    @PersistenceContext(unitName = "StudentPathGuideWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseFacade() {
        super(Course.class);
    }

    @Override
    public List<String> suggestionCourse(String term) {
        
        Query q = em.createNamedQuery("suggestionCourse");
        q.setParameter("term",term.toLowerCase());
        q.setMaxResults(10);
        return q.getResultList();
    }
    
}
