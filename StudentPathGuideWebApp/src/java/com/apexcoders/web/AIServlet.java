/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ayeth
 */
public class AIServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userInput = request.getParameter("prompt");
        String prompt = "Acting as a seasoned career guide. Your response should be concise and straing to the point" + userInput;

        String apiKey = "";

        URL url = new URL("https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=");
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        
        // JSON body for Gemini
        String jsonInput = "{"
                + "\"contents\": [{"
                + "\"parts\": [{\"text\": \"" + prompt + "\"}]"
                + "}]"
                + "}";
        
        OutputStream os = conn.getOutputStream();
        os.write(jsonInput.getBytes());
        os.flush();
        os.close();
        
        
        BufferedReader br;
    
        if (conn.getResponseCode() == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        String line;
        StringBuilder result = new StringBuilder();

        int count = 1;
        while ((line = br.readLine()) != null) {
           // if(count == 7){
            result.append(line);
           /// }
           // count++;
        }
        
        br.close();
        
        String output =  result.toString();
        
        //output = output.substring(8, output.length() - 2);
        
        // Send raw response to JSP
        request.setAttribute("aiResponse", output);
        RequestDispatcher disp = request.getRequestDispatcher("chat.jsp");
        disp.forward(request, response);
        
    }

    

}
