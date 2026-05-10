<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        String[] aiResponse = (String[]) session.getAttribute("aiResponse");
        
           
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

    <%
      if (aiResponse != null) {
          for(String s : aiResponse) {
    %>

        <div class="message ai_response">
            ${sessionScope.aiResponse}
        </div>

    <%
          }
      } else {
    %>

        <div class="message ai_response">
            Hi, I am your AI assistant.
        </div>

    <%
      }
    %>

</div>


        <form action="AIServlet.do" method="post" class="chat" id="chat">
            <input type="text" placeholder="Type a message" name="prompt" id="prompt">
            <button type="submit">
               <i class="fa-solid fa-paper-plane" ></i>
            </button>
        </form>
    </div>
</div>
    <script>
       document.getElementById("chat").addEventListener("submit", async (e) => {
    e.preventDefault();

    const prompt = document.getElementById("prompt");
    const userText = prompt.value.trim();
    if (!userText) return;

    // Show user message
    const chatContainer = document.getElementById("chat_container");
    const userMsg = document.createElement("p");
    userMsg.innerText = userText;
    userMsg.classList.add("message", "user_message");
    chatContainer.appendChild(userMsg);
    prompt.value = "";

    // Send to servlet
    const formData = new FormData();
    formData.append("prompt", userText);

    const res = await fetch("AIServlet.do", {
        method: "POST",
        body: formData
    });

    const html = await res.text();

    // Parse the AI response out of the returned HTML
    const parser = new DOMParser();
    const doc = parser.parseFromString(html, "text/html");
    const aiText = doc.getElementById("ai_response")?.innerText;

    if (aiText) {
        const aiMsg = document.createElement("p");
        aiMsg.innerText = aiText;
        aiMsg.classList.add("message", "ai_message");
        chatContainer.appendChild(aiMsg);
        chatContainer.scrollTop = chatContainer.scrollHeight;
    }
});
    </script>
    

    
</body>
</html>