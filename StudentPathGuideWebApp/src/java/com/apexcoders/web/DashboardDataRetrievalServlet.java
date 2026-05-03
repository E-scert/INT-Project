/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apexcoders.entities.Course;
import com.apexcoders.entities.Student;
import com.apexcoders.entities.UniversityCourses;
import com.apexcoders.model.bl.UniversityCoursesFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JREscert
 */
public class DashboardDataRetrievalServlet extends HttpServlet {

 @EJB private UniversityCoursesFacadeLocal ucf;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("student");
        
        
            String name = student.getUsername();
            Integer grade = student.getGrade();
            Integer aps = student.getAps();
            String field = student.getFieldOfInterest();
            
            session.setAttribute("name", name);
            session.setAttribute("grade", grade);
            session.setAttribute("aps", aps);
            session.setAttribute("field", field);
        
        //gets the list of all course and information
            List<UniversityCourses> course = ucf.findAll();
            List<UniversityCourses> filteredCourses = filterCoursesByAPS(course, student.getAps());
 
            session.setAttribute("course",filteredCourses);
            
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    
       private List<UniversityCourses> filterCoursesByAPS(List<UniversityCourses> allCourses, int studentAps) {
    List<UniversityCourses> filtered = new ArrayList<>();

    
    for (UniversityCourses uc : allCourses) {
        Course c = uc.getCourse();
        Integer minAps = c.getCourseMinAps();

        // If no APS requirement, include it
        if (minAps == null) {
            filtered.add(uc);
        } else {
            // If student's APS is >= requirement, include it
            if (studentAps >= minAps) {
                filtered.add(uc);
            }
        }
    }

    return filtered;
}

   

}
