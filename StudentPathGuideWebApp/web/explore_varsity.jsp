<%-- 
    Document   : explore_varsity
    Created on : May 2, 2026, 9:58:15 AM
    Author     : Rebaona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new,search" />
        <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" /> -->
        <link rel="stylesheet" href="style/style.css">
        <title>Explore Varsity Page</title>
    </head>
    <body>
        <div class="head section">
            <h2>Explore Varsity</h2>
        </div>

        <h2>LIst of Universities</h2>


        <ul>
            <li><a href="explore_page.jsp"><span class="material-symbols-outlined">
                        arrow_back_ios_new
                    </span></a></li>
        </ul>
        <div class="hero">
            <form action="ExploreVarsityServlet.do" method="post" class="explore_container">


                <div class="input_container">
                    <label for="varsityName">Enter Varsity Name</label>
                    <input id="varsityName" type="text" name="varsityName" required="" class="input" placeholder="Tshwane University of Technology">
                    <div id="suggestions"></div>
                </div>

                <button type="submit"><span class="material-symbols-outlined button_primary">search</span></button>

            </form>
        </div>
        <ul>
            <li><a href="explore_page.jsp">Back</a></li>
        </ul>


        <script>
            document.getElementById("varsityName").addEventListener("keyup", function () {

                let query = this.value;
                if (query.length < 2) {
                    document.getElementById("suggestions").style.display = "none";
                    return;
                }
                fetch("VarsitySuggestionServlet.do?term=" + encodeURIComponent(query))
                        .then(response => response.json())
                        .then(data => {
                            let suggestionsBox = document.getElementById("suggestions");
                            suggestionsBox.innerHTML = "";
                            if (data.length > 0) {
                                data.forEach(item => {
                                    let div = document.createElement("div");
                                    div.textContent = item;
                                    div.style.cursor = "pointer";
                                    div.onclick = () => {
                                        document.getElementById("varsityName").value = item;
                                        suggestionsBox.style.display = "none";
                                    };
                                    suggestionsBox.appendChild(div);
                                });
                                suggestionsBox.style.display = "block";
                            } else {
                                suggestionsBox.style.display = "none";
                            }
                        });
            });
        </script>

    </body>
</html>
