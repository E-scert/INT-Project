package com.apexcoders.web;

import com.apexcoders.entities.Student;
import com.apexcoders.exception.InvalidMarksException;
import com.apexcoders.model.bl.StudentFacadeLocal;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateDataServlet extends HttpServlet {

    @EJB
    StudentFacadeLocal sfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         
           Student stud = (Student)session.getAttribute("stud");
           
           String field = stud.getFieldOfInterest();
           String username = stud.getUsername();
           
           Map<String,Integer> subj = stud.getSubjectMarks();
           int counter = 1;
           int grade = stud.getGrade();
           int aps = stud.getAps();
           
           //set the subjects and marks mannually
           
           
           for(Map.Entry<String,Integer> e: subj.entrySet()){
           
           String subjKey = "subj"+counter;
           String percKey = "perc"+counter;
           
           request.setAttribute(subjKey,e.getKey());
           request.setAttribute(percKey,e.getValue());
           counter++;

           }
           
           //set attributes 
           request.setAttribute("field", field);
           request.setAttribute("name",username);
           
           System.out.println(username+""+field);
            System.out.println("Subject "+stud.getSubjectMarks());
           request.setAttribute("subj",subj);
           request.setAttribute("grade",grade);
           request.setAttribute("aps",aps);
           
           request.getRequestDispatcher("update_data.jsp").forward(request, response);
           
           
        

       
    }
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    Student stud = (Student) session.getAttribute("stud");

    // Use new inputs from the form
    stud.setUsername(request.getParameter("username"));
    stud.setGrade(Integer.valueOf(request.getParameter("grade")));
    stud.setFieldOfInterest(request.getParameter("fieldOfInterest"));

    Map<String,Integer> updatedMarks = new HashMap<>();
    for (int i = 1; i <= 6; i++) {
        String subj = request.getParameter("subj" + i);   // subject name from form
        String perc = request.getParameter("perc" + i);   // percentage from form
        if (subj != null && !subj.isEmpty() && perc != null) {
            int mark = Integer.parseInt(perc);
            validateMarks(mark);
            updatedMarks.put(subj, mark);
        }
    }
    stud.setSubjectMarks(updatedMarks);

    int aps = calculateAPS(updatedMarks.values().stream().mapToInt(Integer::intValue).toArray());
    stud.setAps(aps);

    sfl.edit(stud);              // persist changes
    session.setAttribute("stud", stud);

    // Redirect so doGet runs again and sets attributes
    response.sendRedirect("dashboard.jsp");
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