///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.apexcoders.web;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author ayeth
// */
//public class AIServlet extends HttpServlet {
//
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        
//        String userInput = request.getParameter("prompt");
//        String prompt = "Acting as a seasoned career guide. Your response should be concise and straing to the point" + userInput;
//
//        String apiKey = getServletContext().getInitParameter("api");
//
//        URL url = new URL("https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=" + apiKey) ;
//        
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json");
//        conn.setDoOutput(true);
//        
//        // JSON body for Gemini
//        String jsonInput = "{"
//                + "\"contents\": [{"
//                + "\"parts\": [{\"text\": \"" + prompt + "\"}]"
//                + "}]"
//                + "}";
//        
//        OutputStream os = conn.getOutputStream();
//        os.write(jsonInput.getBytes());
//        os.flush();
//        os.close();
//        
//        
//        BufferedReader br;
//    
//        if (conn.getResponseCode() == 200) {
//            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//
//        String line;
//        StringBuilder result = new StringBuilder();
//
//        int count = 1;
//        while ((line = br.readLine()) != null) {
//           
//            result.append(line);
//           
//        }
//        
//        br.close();
//        
//        
//        
//        output = output.substring(8, output.length() - 2);
//        
//        // Send raw response to JSP
//        request.setAttribute("aiResponse", output);
//        RequestDispatcher disp = request.getRequestDispatcher("chat.jsp");
//        disp.forward(request, response);
//        
//    }
//
//    
//
//}
package com.apexcoders.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AIServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        // 1. Get user input safely
        String userInput = request.getParameter("prompt");
        if (userInput == null || userInput.trim().isEmpty()) {
            userInput = "Give general career advice for a high school student.";
        }

<<<<<<< HEAD
        // 2. Improved prompt
        String prompt = "You are an experienced career guidance counselor helping high school students. "
                + "Give clear, concise, and practical advice. Avoid jargon.\n\n"
                + "Student question: " + userInput;

        // Escape quotes
        String safePrompt = prompt.replace("\"", "\\\"");

        String apiKey = getServletContext().getInitParameter("api");

        URL url = new URL("https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=" + apiKey);
=======
        String apiKey = "";

        URL url = new URL("https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=");
        
>>>>>>> 84e04a347b7e76abf1acf8f0b9460391fad1ce14
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);

        String jsonInput = "{"
                + "\"contents\": [{"
                + "\"parts\": [{\"text\": \"" + safePrompt + "\"}]"
                + "}]"
                + "}";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes("UTF-8"));
        }

        int status = conn.getResponseCode();

        BufferedReader br;
        if (status == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        StringBuilder result = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            result.append(line);
        }
        br.close();

        String aiResponseText;

        if (status != 200) {
            aiResponseText = "Sorry, something went wrong. Please try again.";
        } else {
            // ✅ Manual JSON extraction (no libraries)
            String responseStr = result.toString();

            String marker = "\"text\": \"";
            int start = responseStr.indexOf(marker);

            if (start != -1) {
                start += marker.length();

                StringBuilder extracted = new StringBuilder();
                boolean escaping = false;

                for (int i = start; i < responseStr.length(); i++) {
                    char c = responseStr.charAt(i);

                    if (escaping) {
                        extracted.append(c);
                        escaping = false;
                    } else if (c == '\\') {
                        escaping = true;
                    } else if (c == '"') {
                        break;
                    } else {
                        extracted.append(c);
                    }
                }

                aiResponseText = extracted.toString();
            } else {
                aiResponseText = "No response received.";
            }
        }
        
      
        aiResponseText = aiResponseText.replace("**", "");
        
        // (optional) clean stray "n"
        aiResponseText = aiResponseText.replace("\\n", "\n");

        request.setAttribute("aiResponse", (aiResponseText.split("nn")));
        
        
        
        RequestDispatcher disp = request.getRequestDispatcher("chat.jsp");
        disp.forward(request, response);
    }
}