/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apexcoders.entities.Student;
import com.apexcoders.model.bl.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author JREscert
 */
public class ListStudentsBetweenMinAndMaxApsServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        HttpSession session = request.getSession();

        Integer minAps = Integer.valueOf(request.getParameter("minAps"));

        Integer maxAps = Integer.valueOf(request.getParameter("maxAps"));

        List<Student> students = studentFacade.listAllBasedOnMinAndMaxAPS(minAps, maxAps);

        session.setAttribute("students", students);

        RequestDispatcher rsdisp = request.getRequestDispatcher("list_students_based_on_min_max_aps.jsp");
        rsdisp.forward(request, response);
    }


}
