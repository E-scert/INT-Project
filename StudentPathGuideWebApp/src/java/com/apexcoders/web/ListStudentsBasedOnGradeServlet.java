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
public class ListStudentsBasedOnGradeServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer grade = Integer.valueOf(request.getParameter("grade"));

        List<Student> students = studentFacade.listStudentsBasedOnGrade(grade);

        session.setAttribute("students", students);

        RequestDispatcher rsdisp = request.getRequestDispatcher("list_students_based_on_grade.jsp");
        rsdisp.forward(request, response);

    }

}
