/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
window.addEventListener("onload", () => {
    
});

// login info
const loginInfo = {
    actionListener = "LoginServlet.do",
    welcomeText = "Welcome back"
};
function makeLogin() {
    // create screen elements
    const form = document.createElement("form");
    const divTop = document.createElement("div");
    const divBottom = document.createElement("div");
    const elWelcomeText = document.createElement("h1");
    const elLable = document.createElement("label");
    const elInput = document.createElement("input");
    const btnSubmit = document.createElement("button");
    const elSignUp = document.createElement("p");
    const elSpan = document.createElement("span");
    
    
    // insert class, id, etc
    form.classList.add = "main_container";
    form.setAttribute("action", loginInfo.actionListener);
}

