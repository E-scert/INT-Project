/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.apexcoders.web;

import com.apexcoders.model.bl.UniversityFacadeLocal;
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
 * @author Esther
 */
public class VarsitySuggestionServlet extends HttpServlet {

    @EJB
    private UniversityFacadeLocal universityFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String term = request.getParameter("term");
        
        List<String> suggestions = universityFacade.suggestedUniversity(term);

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
