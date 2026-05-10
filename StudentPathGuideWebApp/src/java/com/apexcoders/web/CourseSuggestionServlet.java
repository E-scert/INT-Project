/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apexcoders.model.bl.CourseFacadeLocal;
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
public class CourseSuggestionServlet extends HttpServlet {

    @EJB
    private CourseFacadeLocal cF;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession();

        String term = request.getParameter("term");
        List<String> suggestions = cF.suggestionCourse(term);
      
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        out.print("[");
       for (int i = 0; i < suggestions.size(); i++) {
           out.print("\"" + suggestions.get(i).replace("\"", "\\\"") + "\"");
           if (i < suggestions.size() - 1) {
               out.print(",");
           }
       }
        out.print("]");
        out.flush();
    }



}
