/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.apexcoders.web;

import com.apexcoders.entities.Course;
import com.apexcoders.entities.Student;
import com.apexcoders.entities.UniversityCourses;
import com.apexcoders.model.bl.StudentFacadeLocal;
import com.apexcoders.model.bl.UniversityCoursesFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Esther
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
   @EJB private UniversityCoursesFacadeLocal ucf;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        
        Student student = studentFacade.findByUsername(username);
        
       
        
        if(student != null){
            //the user is found in database   

            request.setAttribute("student", student);
            String name = student.getUsername();
            Integer grade = student.getGrade();
            Integer aps = student.getAps();
            String field = student.getFieldOfInterest();
            
            request.setAttribute("name", name);
            request.setAttribute("grade", grade);
            request.setAttribute("aps", aps);
            request.setAttribute("field", field);
            
            //gets the list of all course and information
            List<UniversityCourses> course = ucf.findAll();
            List<UniversityCourses> filteredCourses = filterCoursesByAPS(course, student.getAps());
 
            request.setAttribute("course",filteredCourses);
            
            RequestDispatcher rsdisp = request.getRequestDispatcher("dashboard.jsp");
            rsdisp.forward(request, response);
        }else{
            //user is not found/doesnt exist        
            request.setAttribute("error", "Invalid username, try again or create");
            RequestDispatcher rsdisp = request.getRequestDispatcher("");
            rsdisp.forward(request, response);
        }

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
