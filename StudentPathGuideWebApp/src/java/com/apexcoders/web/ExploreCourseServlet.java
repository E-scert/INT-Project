/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apexcoders.entities.Course;
import com.apexcoders.entities.University;
import com.apexcoders.entities.UniversityCourses;
import com.apexcoders.model.bl.CourseFacadeLocal;
import com.apexcoders.model.bl.UniversityCoursesFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ExploreCourseServlet extends HttpServlet {

   @EJB private CourseFacadeLocal cf;
   @EJB private UniversityCoursesFacadeLocal ucfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        
        String term = request.getParameter("term");
        
        Course courses = cf.findCoursesByName(term);
        List<UniversityCourses> universities = ucfl.findUniversityByCourseName(term);
        
        
        session.setAttribute("courses",courses);
        session.setAttribute("unies",universities);
                
        request.getRequestDispatcher("explore_course.jsp").forward(request, response);
        
    }

    
}
