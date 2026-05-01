/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.apexcoders.web;

import com.apexcoders.entities.Student;
import com.apexcoders.model.bl.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        
        Student student = studentFacade.findByUsername(username);
        
        if(student != null){
            //the user is found in database   
            
            
            
            
            
            request.setAttribute("student", student);
            
            
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
