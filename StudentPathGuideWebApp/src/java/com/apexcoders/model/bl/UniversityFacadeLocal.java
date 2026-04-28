/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.model.bl;

import com.apexcoders.entities.University;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JREscert
 */
@Local
public interface UniversityFacadeLocal {

    void create(University university);

    void edit(University university);

    void remove(University university);

    University find(Object id);

    List<University> findAll();

    List<University> findRange(int[] range);

    int count();
    
}
