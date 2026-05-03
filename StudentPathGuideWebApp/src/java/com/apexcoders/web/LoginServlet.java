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
import javax.servlet.http.HttpSession;

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
        //create a session 
        HttpSession session = request.getSession(true);
        
        String username = request.getParameter("username");
        
        Student student = studentFacade.findByUsername(username);
        
       
        
        if(student != null){
            //the user is found in database   

            session.setAttribute("student", student);
       
             String name = student.getUsername();
            Integer grade = student.getGrade();
            Integer aps = student.getAps();
            String field = student.getFieldOfInterest();
            
            session.setAttribute("name", name);
            session.setAttribute("grade", grade);
            session.setAttribute("aps", aps);
            session.setAttribute("field", field);
            
            //gets the list of all course and information

            List<UniversityCourses> filteredCourses = ucf.filterByFieldAndAps(student.getFieldOfInterest(),student.getAps());
 
            session.setAttribute("course",filteredCourses);
            
            
            RequestDispatcher rsdisp = request.getRequestDispatcher("dashboard.jsp");
            rsdisp.forward(request, response);
        }else{
            //user is not found/doesnt exist        
            request.setAttribute("error", "Invalid username, try again or create");
            RequestDispatcher rsdisp = request.getRequestDispatcher("");
            rsdisp.forward(request, response);
        }

    }

     

  

}
