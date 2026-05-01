/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apexcoders.entities.Student;
import com.apexcoders.exception.InvalidMarksException;
import com.apexcoders.model.bl.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ayeth
 */
public class SignUpServlet extends HttpServlet {

    @EJB StudentFacadeLocal sfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{
            
        Integer grade = Integer.valueOf(request.getParameter("grade"));
        String username = request.getParameter("username");
        String field = request.getParameter("field");

        String subject1 = request.getParameter("subject1");
        String subject2 = request.getParameter("subject2");
        String subject3 = request.getParameter("subject3");
        String subject4 = request.getParameter("subject4");
        String subject5 = request.getParameter("subject5");
        String subject6 = request.getParameter("subject6");
        
        Integer perc1 = Integer.valueOf(request.getParameter("perc1"));
        Integer perc2 = Integer.valueOf(request.getParameter("perc2"));
        Integer perc3 = Integer.valueOf(request.getParameter("perc3"));
        Integer perc4 = Integer.valueOf(request.getParameter("perc4"));
        Integer perc5 = Integer.valueOf(request.getParameter("perc5"));
        Integer perc6 = Integer.valueOf(request.getParameter("perc6"));
        
        // VALIDATE HERE
        validateMarks(perc1, perc2, perc3, perc4, perc5, perc6);
        
        // Create student
        Student stud = new Student();
        stud.setUsername(username);
        stud.setGrade(grade);
        stud.setFieldOfInterest(field);

        // Add subjects to Map
        Map<String, Integer> marks = new HashMap<>();
        marks.put(subject1, perc1);
        marks.put(subject2, perc2);
        marks.put(subject3, perc3);
        marks.put(subject4, perc4);
        marks.put(subject5, perc5);
        marks.put(subject6, perc6);

        stud.setSubjectMarks(marks);

        // Calculate APS
        int aps = calculateAPS(perc1, perc2, perc3, perc4, perc5, perc6);
        stud.setAps(aps);

        //PERSIST TO DATABASE
        sfl.create(stud);
 
        // Forward to next page
        RequestDispatcher disp = request.getRequestDispatcher("success.jsp");
        disp.forward(request, response);
        }catch(InvalidMarksException e){
            
            // Handle your custom exception
            request.setAttribute("error", e.getMessage());
            RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
            disp.forward(request, response);

        } catch (NumberFormatException e) {

            //Handles non-numeric input like "abc"
            request.setAttribute("error", "Please enter valid numeric marks.");
            RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
            disp.forward(request, response);
        }
        
          request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    

    }

    private int calculateAPS(int... marks) {
    int total = 0;

        for (int m : marks) {
            if (m >= 80) total += 7;
            else if (m >= 70) total += 6;
            else if (m >= 60) total += 5;
            else if (m >= 50) total += 4;
            else if (m >= 40) total += 3;
            else if (m >= 30) total += 2;
            else total += 1;
        }

        return total;
    }
    
    private void validateMarks(int... marks) {
    for (int m : marks) {
        if (m < 0 || m > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100. Invalid value: " + m);
        }
    }
}
    

}
