package com.apexcoders.web;

import com.apexcoders.entities.Student;
import com.apexcoders.exception.InvalidMarksException;
import com.apexcoders.model.bl.StudentFacadeLocal;
import java.io.IOException;
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
           
           
        

       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    }

    private Student UpdateData(Student student,Integer grade,Integer marks,String subject, String fieldOfInterest) {

        student.setGrade(grade);
        student.setFieldOfInterest(fieldOfInterest);

        Map<String, Integer> subjectMark = student.getSubjectMarks();

        subjectMark.put(subject, marks);

        student.setSubjectMarks(subjectMark);

        return student;
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