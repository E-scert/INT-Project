<%-- 
    Document   : explore_course
    Created on : May 2, 2026, 9:52:15 AM
    Author     : Rebaona
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back_ios_new,search" />
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/style.css">
       <title>Explore Course Page</title>
</head>
<body>
    <div class="head section">
        <h2>Explore Course</h2>
    </div>
    <ul>
        <li><a href="explore_page.jsp"><span class="material-symbols-outlined">
arrow_back_ios_new
</span></a></li>
    </ul>
    <div class="course_search">  
    <form action="ExploreCourseServlet.do" method="GET">
    
            
            <div style="position:relative;">
                <input type="text" id="courseName" placeholder="Enter name of course" name="term" required="">
                <div id="suggestions"
                     style="border:1px solid #ccc;
                            display:none;
                            position:absolute;
                            top:100%;
                            left:0;
                            background:white;
                            width:100%;
                            z-index:1000;">
                </div>
            </div>
        
            <button type=submit>
                <span class="material-symbols-outlined button_primary">
search
</span>
            </button>
        
</form>
    </div>
    
    <!--output-->
    
<c:if test ="${not empty courses}">
    <h3>Search results:</h3>
    <p>Name: ${courses.courseName}</p>
    <p>Field: ${courses.courseField}</p>
    <p>APS: ${courses.courseMinAps}</p>
    <p>Description: ${courses.courseDescription}</p>
    <p>Required Subjects: ${courses.courseRequiredSubjects}</p>
    <h3>Universities offering this course</h3>
    <c:if test="${not empty unies}">
        
        <ul>
            <c:forEach var="u" items="${unies}">
                
                <li>
                    ${u.university.universityName}- Under the faculty of -<b style="color: darkslategrey">${u.facultyName}</b> 
                </li>
                
            </c:forEach>
        </ul>
        
    </c:if>
</c:if>
    
   
    
<c:if test="${empty courses}">
    <p>No courses found for your search</p>

</c:if>
   

    
    <script>
document.getElementById("courseName").addEventListener("keyup", function() {
    let query = this.value;
    if (query.length < 2) {
        document.getElementById("suggestions").style.display = "none";
        return;
    }
    fetch("CourseSuggestionServlet.do?term=" + encodeURIComponent(query))
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
                        document.getElementById("courseName").value = item;
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
