/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apexcoders.entities.Student;
import com.apexcoders.model.bl.StudentFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JREscert
 */
public class ListStudentsBasedOnFieldServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;





    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String field = request.getParameter("field");

        List<Student> students = studentFacade.listStudentsBasedOnField(field);

        request.setAttribute("students", students);
        
        RequestDispatcher rsdip = request.getRequestDispatcher("");
        rsdip.forward(request, response);





}
    
}
