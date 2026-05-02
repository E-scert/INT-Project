<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!--   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> -->
    <link rel="stylesheet" href="style/style.css">
    <title>Chat with Javis</title>
</head>
<body>
    <div id="chat_screen">

        <div class="chat_container">
        
          

        </div>


        <form action="AIServlet.do" method="post" class="chat" id="chat">
            <input type="text" placeholder="Type a message" name="prompt" id="prompt">
            <button type="submit">
               <i class="fa-solid fa-paper-plane" ></i>
            </button>
        </form>
    </div>

    <script src="scripts/app.js"></script>
</body>
</html>