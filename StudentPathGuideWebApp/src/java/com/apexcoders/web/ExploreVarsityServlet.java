/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.apexcoders.web;

import com.apexcoders.entities.University;
import com.apexcoders.entities.UniversityCourses;
import com.apexcoders.model.bl.UniversityCoursesFacadeLocal;
import com.apexcoders.model.bl.UniversityFacadeLocal;
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
 * @author Koketso
 */
public class ExploreVarsityServlet extends HttpServlet {

    @EJB
    private UniversityCoursesFacadeLocal universityCoursesFacade;

    @EJB
    private UniversityFacadeLocal universityFacade;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String input = request.getParameter("varsityName").trim().toLowerCase();
        
        //Find the university
        University university = universityFacade.findByNameOrAbbreviation(input);
        
        if(university == null ){
        
            session.setAttribute("error", "University Not found, try again.");
            RequestDispatcher rsdisp = request.getRequestDispatcher("uni_error.jsp");
            rsdisp.forward(request, response);
            return;
        }
        
         session.setAttribute("varsityName", input);
        
        //GET COURSES AND FALCULATIES
        
        List<UniversityCourses> unicourses = universityCoursesFacade.findByUniversity(university.getId());
          
        //GET FACULTIES
        
        List<String> faculties = new ArrayList<>();
        
        for(UniversityCourses uc : unicourses){
        
            String faculty = uc.getFacultyName();
            
            if(!faculties.contains(faculty)){
            
                faculties.add(faculty);
            }
        }
        
        //SEND TO JSP
        session.setAttribute("university", university);
        session.setAttribute("faculties", faculties);
        session.setAttribute("courses", unicourses);

        
        request.getRequestDispatcher("explore_varsity_outcome.jsp").forward(request, response);
        
        
    }

}
