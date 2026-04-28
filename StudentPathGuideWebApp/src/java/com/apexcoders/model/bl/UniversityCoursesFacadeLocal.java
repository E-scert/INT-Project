/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.model.bl;

import com.apexcoders.entities.UniversityCourses;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JREscert
 */
@Local
public interface UniversityCoursesFacadeLocal {

    void create(UniversityCourses universityCourses);

    void edit(UniversityCourses universityCourses);

    void remove(UniversityCourses universityCourses);

    UniversityCourses find(Object id);

    List<UniversityCourses> findAll();

    List<UniversityCourses> findRange(int[] range);

    int count();
    
}
