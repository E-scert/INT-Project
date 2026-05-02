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

/**
 *
 * @author Koketso
 */
public class ExploreVarsityServlet extends HttpServlet {

    @EJB
    private UniversityCoursesFacadeLocal universityCoursesFacade;

    @EJB
    private UniversityFacadeLocal universityFacade;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExploreVarsityServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExploreVarsityServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String input = request.getParameter("varsityName").trim();
        
        //Find the university
        University university = universityFacade.findByNameOrAbbreviation(input);
        
        if(university == null){
        
            request.setAttribute("error", "University Not found, try again.");
            RequestDispatcher rsdisp = request.getRequestDispatcher("uni_error.jsp");
            rsdisp.forward(request, response);
            return;
        }
        
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
        request.setAttribute("university", university);
        request.setAttribute("faculties", faculties);
        request.setAttribute("courses", unicourses);
        
        RequestDispatcher rsdisp = request.getRequestDispatcher("explore_varsity_outcome.jsp");
        rsdisp.forward(request, response);
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
