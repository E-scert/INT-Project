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
        <li><a href="explore_page.jsp"><span class="material-symbols-outlined back">
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
    <div class="card">
        <h3>Search results:</h3>
    <p>Name: ${courses.courseName}</p>
    <p>Field: ${courses.courseField}</p>
    <p>APS: ${courses.courseMinAps}</p>
    <p id="course_disc">Description: ${courses.courseDescription}</p>
    <p>Required Subjects: ${courses.courseRequiredSubjects}</p>
</div>
    <h3 style="text-align: center; font-size: 1.35rem;">Universities offering this course</h3>
    <c:if test="${not empty unies}">
        
        <ul class="course_list">
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
        const course = "${courses.courseDescription}";
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

function appendToDisc(desc) {
    const discEl = document.getElementById("course_disc");

    discEl.innerText = "" + desc;
}

window.addEventListener("load", async ()=>{
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
                                    + "The student wants to know the practical information about "
                                    + course
                            }]
                        }]
                    })
                }
            );

            const data = await response.json();
            

            if (response.ok) {
                const aiText = data.candidates[0].content.parts[0].text;
                // Clean up markdown bold markers
                const cleaned = aiText.replace(/\*\*/g, "");
                appendToDisc(cleaned);
            } else {
                appendToDisc("Error: " + data.error.message);
            }

        } catch (err) {
            
            appendToDisc("Could not reach Javis. Please check your connection.");
            console.error(err);
        }
});

</script>
    
    
    
</body>
</html>
