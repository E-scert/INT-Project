// //
// //package com.apexcoders.web;
// //
// //import java.io.BufferedReader;
// //import java.io.IOException;
// //import java.io.InputStreamReader;
// //import java.io.OutputStream;
// //import java.net.HttpURLConnection;
// //import java.net.URL;
// //
// //import javax.servlet.RequestDispatcher;
// //import javax.servlet.ServletException;
// //import javax.servlet.http.HttpServlet;
// //import javax.servlet.http.HttpServletRequest;
// //import javax.servlet.http.HttpServletResponse;
// //import java.util.Arrays;
// //import java.util.logging.Level;
// //import java.util.logging.Logger;
// //import javax.naming.InitialContext;
// //import javax.naming.NamingException;
// //import javax.servlet.http.HttpSession;
// //
// //public class AIServlet extends HttpServlet {
// //
// //    @Override
// //    protected void doPost(HttpServletRequest request, HttpServletResponse response)
// //            throws ServletException, IOException {
// //        try {
// //            HttpSession session=request.getSession();
// //            response.setContentType("text/html;charset=UTF-8");
// //            
// //            // 1. Get user input safely
// //            String userInput = request.getParameter("prompt");
// //            if (userInput == null || userInput.trim().isEmpty()) {
// //                userInput = "Give general career advice for a high school student.";
// //            }
// //            
// //            
// //            // 2. Improved prompt
// //            String prompt = "You are an experienced career guidance counselor helping high school students. "
// //                    + "Give clear, concise, and practical advice. Avoid jargon.\n\n"
// //                    + "Student question: " + userInput;
// //            
// //            // Escape quotes
// //            String safePrompt = prompt.replace("\"", "\\\"");
// //            
// //            InitialContext ctx = new InitialContext();
// //            String apiKey = (String) ctx.lookup("java:comp/env/gemini/apiKey");
// //            
// //            URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key" + apiKey);
// //            
// //            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
// //            
// //            conn.setRequestMethod("POST");
// //            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
// //            conn.setDoOutput(true);
// //            
// //            String jsonInput = "{"
// //                    + "\"contents\": [{"
// //                    + "\"parts\": [{\"text\": \"" + safePrompt + "\"}]"
// //                    + "}]"
// //                    + "}";
// //            
// //            try (OutputStream os = conn.getOutputStream()) {
// //                os.write(jsonInput.getBytes("UTF-8"));
// //            }
// //            
// //            int status = conn.getResponseCode();
// //            
// //            BufferedReader br;
// //            if (status == 200) {
// //                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
// //            } else {
// //                br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
// //            }
// //            
// //            StringBuilder result = new StringBuilder();
// //            String line;
// //            
// //            while ((line = br.readLine()) != null) {
// //                result.append(line);
// //            }
// //            br.close();
// //            
// //            String aiResponseText;
// //            
// //            if (status != 200) {
// //                aiResponseText = "Sorry, something went wrong. Please try again.";
// //            } else {
// //                // ✅ Manual JSON extraction (no libraries)
// //                String responseStr = result.toString();
// //                
// //                String marker = "\"text\": \"";
// //                int start = responseStr.indexOf(marker);
// //                
// //                if (start != -1) {
// //                    start += marker.length();
// //                    
// //                    StringBuilder extracted = new StringBuilder();
// //                    boolean escaping = false;
// //                    
// //                    for (int i = start; i < responseStr.length(); i++) {
// //                        char c = responseStr.charAt(i);
// //                        
// //                        if (escaping) {
// //                            extracted.append(c);
// //                            escaping = false;
// //                        } else if (c == '\\') {
// //                            escaping = true;
// //                        } else if (c == '"') {
// //                            break;
// //                        } else {
// //                            extracted.append(c);
// //                        }
// //                    }
// //                    
// //                    aiResponseText = extracted.toString();
// //                } else {
// //                    aiResponseText = "No response received.";
// //                }
// //            }
// //            
// //            
// //            aiResponseText = aiResponseText.replace("**", "");
// //            
// //            // (optional) clean stray "n"
// //            aiResponseText = aiResponseText.replace("\\n", "\n");
// //            System.out.println("==================================");
// //            System.out.println(aiResponseText);
// //            
// //            session.setAttribute("aiResponse", aiResponseText.split("\\n\\n"));
// //            
// //            
// //            
// //            RequestDispatcher disp = request.getRequestDispatcher("chat.jsp");
// //            disp.forward(request, response);
// //        }   catch (NamingException ex) {
// //            Logger.getLogger(AIServlet.class.getName()).log(Level.SEVERE, null, ex);
// //        }
// //    }
// //}
// package com.apexcoders.web;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStream;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import javax.naming.InitialContext;
// import javax.naming.NamingException;
// import javax.servlet.http.HttpSession;

// public class AIServlet extends HttpServlet {

//     @Override
//     protected void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//         HttpSession session = request.getSession();
//         response.setContentType("text/html;charset=UTF-8");

//         // 1. Get user input
//         String userInput = request.getParameter("prompt");
//         if (userInput == null || userInput.trim().isEmpty()) {
//             userInput = "Give general career advice for a high school student.";
//         }

//         // 2. Build prompt
//         String prompt = "You are an experienced career guidance counselor helping high school students. "
//                 + "Give clear, concise, and practical advice. Avoid jargon.\n\n"
//                 + "Student question: " + userInput;

//         String safePrompt = prompt.replace("\"", "\\\"").replace("\n", "\\n");

//         try {
//             // 3. Get API key from JNDI
//             InitialContext ctx = new InitialContext();
//             String apiKey = (String) ctx.lookup("java:comp/env/groq/apiKey");

//             // 4. Build request
//             URL url = new URL("https://api.groq.com/openai/v1/chat/completions");
//             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//             conn.setRequestMethod("POST");
//             conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//             conn.setRequestProperty("Authorization", "Bearer " + apiKey);
//             conn.setDoOutput(true);

//             // 5. Groq uses OpenAI-compatible JSON format
//             String jsonInput = "{"
//                     + "\"model\": \"llama-3.3-70b-versatile\","
//                     + "\"messages\": ["
//                     + "  {\"role\": \"user\", \"content\": \"" + safePrompt + "\"}"
//                     + "],"
//                     + "\"max_tokens\": 1024"
//                     + "}";

//             System.out.println("=== SENDING REQUEST TO GROQ ===");

//             try (OutputStream os = conn.getOutputStream()) {
//                 os.write(jsonInput.getBytes("UTF-8"));
//             }

//             // 6. Read response
//             int status = conn.getResponseCode();
//             System.out.println("=== GROQ STATUS: " + status);

//             BufferedReader br;
//             if (status == 200) {
//                 br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//             } else {
//                 br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
//             }

//             StringBuilder result = new StringBuilder();
//             String line;
//             while ((line = br.readLine()) != null) {
//                 result.append(line);
//             }
//             br.close();

//             System.out.println("=== RAW RESPONSE: " + result.toString());

//             // 7. Extract AI text
//             String aiResponseText;

//             if (status != 200) {
//                 aiResponseText = "Error from Groq: " + result.toString();
//             } else {
//                 String responseStr = result.toString();
//                 // Groq response: {"choices":[{"message":{"content":"..."}}]}
//                 String marker = "\"content\":\"";
//                 int start = responseStr.indexOf(marker);

//                 if (start != -1) {
//                     start += marker.length();
//                     StringBuilder extracted = new StringBuilder();
//                     boolean escaping = false;

//                     for (int i = start; i < responseStr.length(); i++) {
//                         char c = responseStr.charAt(i);
//                         if (escaping) {
//                             if (c == 'n') extracted.append('\n');
//                             else if (c == 't') extracted.append('\t');
//                             else extracted.append(c);
//                             escaping = false;
//                         } else if (c == '\\') {
//                             escaping = true;
//                         } else if (c == '"') {
//                             break;
//                         } else {
//                             extracted.append(c);
//                         }
//                     }
//                     aiResponseText = extracted.toString();
//                 } else {
//                     aiResponseText = "Could not parse response.";
//                 }
//             }

//             // 8. Clean up formatting
//             aiResponseText = aiResponseText.replace("**", "");
//             System.out.println("=== AI RESPONSE: " + aiResponseText);

//             // 9. Store and forward
//             session.setAttribute("aiResponse", aiResponseText);
//             RequestDispatcher disp = request.getRequestDispatcher("chat.jsp");
//             disp.forward(request, response);

//         } catch (NamingException ex) {
//             Logger.getLogger(AIServlet.class.getName()).log(Level.SEVERE, null, ex);
//             session.setAttribute("aiResponse", "Configuration error: API key not found.");
//             RequestDispatcher disp = request.getRequestDispatcher("chat.jsp");
//             disp.forward(request, response);
//         }
//     }
// }