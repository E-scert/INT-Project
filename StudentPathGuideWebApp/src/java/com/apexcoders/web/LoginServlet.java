package com.apexcoders.web;

import com.apex.password.crypt.PasswordUtil;
import com.apexcoders.entities.Student;
import com.apexcoders.entities.UniversityCourses;
import com.apexcoders.model.bl.StudentFacadeLocal;
import com.apexcoders.model.bl.UniversityCoursesFacadeLocal;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
    @EJB 
    private UniversityCoursesFacadeLocal ucf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            // Find student by username only
            Student student = studentFacade.findByUsername(username);
            
            if (student != null) {
                // Hash the input password
                String hashedInput = PasswordUtil.hashPassword(password);
                
                // Compare with stored hash
                if (hashedInput.equals(student.getPassword())) {
                    // ✅Password matches
                    session.setAttribute("stud", student);
                    session.setAttribute("name", student.getUsername());
                    session.setAttribute("grade", student.getGrade());
                    session.setAttribute("aps", student.getAps());
                    session.setAttribute("field", student.getFieldOfInterest());

                    // Get filtered courses
                    List<UniversityCourses> filteredCourses = 
                        ucf.filterByFieldAndAps(student.getFieldOfInterest(), student.getAps());
                    session.setAttribute("course", filteredCourses);

                    RequestDispatcher rsdisp = request.getRequestDispatcher("dashboard.jsp");
                    rsdisp.forward(request, response);
                } else {
                    //  Wrong password
                    session.setAttribute("error", "Invalid password, try again.");
                    RequestDispatcher rsdisp = request.getRequestDispatcher("login.jsp");
                    rsdisp.forward(request, response);
                }
            } else {
                //  User not found
                session.setAttribute("error", "Invalid username, try again or create an account.");
                RequestDispatcher rsdisp = request.getRequestDispatcher("login.jsp");
                rsdisp.forward(request, response);
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Internal error during login.");
            RequestDispatcher rsdisp = request.getRequestDispatcher("login.jsp");
            rsdisp.forward(request, response);
        }
    }
}
