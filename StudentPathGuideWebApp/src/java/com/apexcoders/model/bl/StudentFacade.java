/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.model.bl;

import com.apexcoders.entities.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JREscert
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "StudentPathGuideWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public Student findByUsername(String username) {
        
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.username = :uname");
        
        query.setParameter("uname", username);
        //using a try block to check that the studemt really does exist.
        //Student student = (Student)query.getSingleResult();
        
        Student student = null;
                
        try {
            student = (Student) query.getSingleResult();
            
        } catch (Exception e) {
            student = null;
        }
        
        return student;

    }
    
}
