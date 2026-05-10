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
        String[] aiResponse = (String[]) request.getAttribute("aiResponse");
        
           
    %>
    <div class="head section">
        <ul>
        <li><a href="dashboard.jsp"><span class="material-symbols-outlined back">
arrow_back_ios_new
</span></a></li>
    </ul>
        <h2>Chat with Javis</h2>
    </div>
    <div id="chat_screen" class="chat_screen">

        <div class="chat_container">
        
           <div class="gemini_reponse_contaier">
               <p class="message ai_response">
                <%
                  if (aiResponse != null) {
                    for(String s : aiResponse) {
                %>
                        <span><%= s %></span><br/>
                <%
                    }
                } else {
                %>
                    <span>Hi, I am you AI assistance. I am here to assist with any questions you might have</span>
                <%
                }
                %>
               </p>
           </div>
        </div>


        <form action="a.do" method="post" class="chat" id="chat">
            <input type="text" placeholder="Type a message" name="prompt" id="prompt">
            <button type="submit">
               <i class="fa-solid fa-paper-plane" ></i>
            </button>
        </form>
    </div>

    <script src="scripts/app.js">
    </script>
    

    
</body>
</html>