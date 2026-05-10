/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import com.apex.password.crypt.PasswordUtil;
import com.apexcoders.entities.Course;
import com.apexcoders.entities.Student;
import com.apexcoders.entities.UniversityCourses;
import com.apexcoders.exception.InvalidMarksException;
import com.apexcoders.model.bl.StudentFacadeLocal;
import com.apexcoders.model.bl.UniversityCoursesFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ayeth
 */
public class SignUpServlet extends HttpServlet {

    @EJB StudentFacadeLocal sfl;
    @EJB UniversityCoursesFacadeLocal ucf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            
        Integer grade = Integer.valueOf(request.getParameter("grade"));
        String username = request.getParameter("username");
        String field = request.getParameter("field");
        String password = request.getParameter("password");

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
       
        
        //hash the password
        String hashed = PasswordUtil.hashPassword(password);
        stud.setPassword(hashed);

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
        
        session.setAttribute("name",username);
        session.setAttribute("grade",grade);
        session.setAttribute("aps",aps);
        session.setAttribute("field",field);
        session.setAttribute("password",password);
        
        
       //get university course
        List<UniversityCourses> filteredCourses = ucf.filterByFieldAndAps(field,aps);
        session.setAttribute("course",filteredCourses);
        session.setAttribute("stud",stud);
       
 
        // Forward to next page
        RequestDispatcher disp = request.getRequestDispatcher("dashboard.jsp");
        disp.forward(request, response);
        }catch(InvalidMarksException e){
            
            // Handle your custom exception
            session.setAttribute("error", e.getMessage());
            RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
            disp.forward(request, response);

        } catch (NumberFormatException e) {

            //Handles non-numeric input like "abc"
            session.setAttribute("error", "Please enter valid numeric marks.");
            RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
            disp.forward(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         

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
 
