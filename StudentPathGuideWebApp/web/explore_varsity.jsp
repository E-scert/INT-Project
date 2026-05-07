<%-- 
    Document   : explore_varsity
    Created on : May 2, 2026, 9:58:15 AM
    Author     : Rebaona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Explore Varsity Page</title>
    </head>
    <body>
        <h2>Explore Varsity</h2>

        <form action="ExploreVarsityServlet.do" method="post">

            <table border="1" cellpadding="10">
                <tr>
                    <td>Enter Varsity Name:</td>
                    <td style="position: relative;">
                        <input type="text" id="varsityName" name="varsityName" required="">
                        <div id="suggestions" style="border: 1px solid #ccc;
                             display: none;
                             position: absolute;
                             top: 100%;
                             left:0;
                             background:white;
                             width:100%;
                             left:0;
                             background: white;
                             width: 100%;
                             z-index: 1000;" >                        
                        </div>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Explore Varsity"></td>
                </tr>
            </table>
        </form>

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
