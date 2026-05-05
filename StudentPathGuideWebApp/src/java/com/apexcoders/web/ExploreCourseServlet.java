/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apexcoders.entities.Course;
import com.apexcoders.model.bl.CourseFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JREscert
 */
public class ExploreCourseServlet extends HttpServlet {

   @EJB private CourseFacadeLocal cf;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String term = request.getParameter("term");
        
        Course courses = cf.findCoursesByName(term);
        
        System.out.println(courses.getCourseRequiredSubjects());
        request.setAttribute("courses",courses);
        request.getRequestDispatcher("explore_course.jsp").forward(request, response);
        
    }

    
}
