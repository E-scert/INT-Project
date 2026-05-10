package com.apexcoders.web;

import com.apexcoders.entities.Student;
import com.apexcoders.model.bl.StudentFacadeLocal;
import java.io.IOException;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDataServlet extends HttpServlet {

    @EJB
    StudentFacadeLocal sfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        Integer grade = Integer.valueOf(request.getParameter("grade"));
        Integer marks = Integer.valueOf(request.getParameter("marks"));
        String subject = request.getParameter("subject");
        String fieldOfInterest = request.getParameter("fieldOfInterest");

        Student stud = sfl.findByUsername(username);

        if (stud != null) {

            Student student = UpdateData(stud,grade,marks,subject,fieldOfInterest );

            sfl.edit(student);

            response.getWriter().println("Student updated successfully.");

        } else {

            response.getWriter().println("Student not found.");
        }
    }

    private Student UpdateData(Student student,Integer grade,Integer marks,String subject, String fieldOfInterest) {

        student.setGrade(grade);
        student.setFieldOfInterest(fieldOfInterest);

        Map<String, Integer> subjectMark = student.getSubjectMarks();

        subjectMark.put(subject, marks);

        student.setSubjectMarks(subjectMark);

        return student;
    }
}