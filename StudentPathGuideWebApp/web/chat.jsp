<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.naming.InitialContext"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new,search" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> 
    <link rel="stylesheet" href="style/style.css">
    <title>Chat with Javis</title>
</head>
<body>

<%
    // Fetch API key server-side from GlassFish JNDI
    String apiKey = "";
    String username = (String) session.getAttribute("name");
    Map<String, Integer> subjectsMarksMap = (Map) session.getAttribute("subjects");
    String subMarks = "";
    if(subjectsMarksMap.size() == 6){
     subMarks = subjectsMarksMap.toString();
    System.out.println("========================================");
    System.out.println(subMarks);
    }
    Integer grade = (Integer) session.getAttribute("grade");
    String fieldOfInterest = (String) session.getAttribute("field");
    
    try {
        InitialContext ctx = new InitialContext();
        apiKey = (String) ctx.lookup("java:comp/env/gemini/apiKey");
    } catch (Exception e) {
        apiKey = "";
    }
%>

<div class="head section">
    <ul>
        <li><a href="dashboard.jsp"><span class="material-symbols-outlined back">
arrow_back_ios_new
</span></a></li>
    </ul>
    <h2>Chat with Javis</h2>
</div>

<div class="app">
    <div id="chat_screen" class="chat_screen">
        <div class="chat_container" id="chat_container">
            <div class="message ai_response">
                Hi, I am Javis, your AI career assistant. How can I help you today?
                
            </div>
        </div>


        <form class="chat" id="chat">

            <input type="text" placeholder="Type a message" name="prompt" id="prompt">
            <button type="submit">
                <i class="fa-solid fa-paper-plane"></i>
            </button>
        </form>
    </div>
</div>

<script>
    // API key injected server-side, never visible in source as a variable name
    const CONFIG = { k: "<%= apiKey %>" };
    const student = {
        username: "<%= username%>",
        grade: "<%= grade%>",
        subjects: "<%= subMarks%>",
        fieldOfInterest: "<%= fieldOfInterest%>"
    };

    const chatContainer = document.getElementById("chat_container");
    const form = document.getElementById("chat");
    const promptInput = document.getElementById("prompt");

    function appendMessage(text, cssClass) {
        const msg = document.createElement("div");
        msg.classList.add("message", cssClass);
        msg.innerText = text;
        chatContainer.appendChild(msg);
        chatContainer.scrollTop = chatContainer.scrollHeight;
    }

    function appendTypingIndicator() {
        const indicator = document.createElement("div");
        indicator.classList.add("message", "ai_response");
        indicator.id = "typing";
        indicator.innerText = "Javis is typing...";
        chatContainer.appendChild(indicator);
        chatContainer.scrollTop = chatContainer.scrollHeight;
    }

    function removeTypingIndicator() {
        const indicator = document.getElementById("typing");
        if (indicator) indicator.remove();
    }

    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        console.log("We are live!");
        console.log(student.subjects);
        const userText = promptInput.value.trim();
        if (!userText) return;

        // Show user message
        appendMessage(userText, "user_message");
        promptInput.value = "";

        // Show typing indicator
        appendTypingIndicator();

        try {
            const response = await fetch(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + CONFIG.k,
                {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({
                        contents: [{
                            parts: [{
                                text: "You are an experienced career guidance counselor helping high school students. "
                                    + "Give clear, concise, and practical advice. Avoid jargon.\n\n"
                                    + "Student name: " + student.username
                                    + "Student grade: " + student.grade
                                    + "Student field of interest: " + student.fieldOfInterest 
                                    + "Student subjects and percentages: " + student.subjects
                                    + "Student question: " + userText
                            }]
                        }]
                    })
                }
            );

            const data = await response.json();
            removeTypingIndicator();

            if (response.ok) {
                const aiText = data.candidates[0].content.parts[0].text;
                // Clean up markdown bold markers
                const cleaned = aiText.replace(/\*\*/g, "");
                appendMessage(cleaned, "ai_response");
            } else {
                appendMessage("Error: " + data.error.message, "ai_response");
            }

        } catch (err) {
            removeTypingIndicator();
            appendMessage("Could not reach Javis. Please check your connection.", "ai_response");
            console.error(err);
        }
    });
</script>

</body>
</html>