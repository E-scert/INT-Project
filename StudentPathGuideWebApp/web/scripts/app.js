/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
window.addEventListener("load", () => {
  const main = document.getElementById("main");

  //main.append(makeLogin());
});

// login info
const loginInfo = {
  servlet: "LoginServlet.do",
  welcomeText: "Welcome back",
  imgUrl:
    "https://th.bing.com/th/id/R.fbf39144bff5c02898fdc8fd583f84b6?rik=qLhp7D3LhK%2fQgA&pid=ImgRaw&r=0",
};
function makeLogin() {
  // create screen elements
  const form = document.createElement("form");
  const divTop = document.createElement("div");
  const divBottom = document.createElement("div");
  const elWelcomeText = document.createElement("h1");
  const elLabel = document.createElement("label");
  const elInput = document.createElement("input");
  const btnSubmit = document.createElement("button");
  const elSignUp = document.createElement("p");
  const elImg = document.createElement("img");
  const imgCont = document.createElement("div");

  // insert class, id, etc
  form.classList.add("main_container");
  form.action = loginInfo.servlet;
  divTop.classList.add("Welcome_container");
  divBottom.classList.add("login_container");
  elWelcomeText.classList.add("welcome");
  elImg.classList.add("login_img");
  elImg.src = loginInfo.imgUrl;
  imgCont.classList.add("login_img_container");
  elWelcomeText.innerText = loginInfo.welcomeText;
  elInput.placeholder = "username";
  btnSubmit.textContent = "Login";

  // combine
  imgCont.append(elImg);
  divTop.append(imgCont);
  divTop.append(elWelcomeText);

  elLabel.innerText = "Enter Username";
  elInput.type = "text";
  btnSubmit.type = "submit";

  elSignUp.innerHTML =
    "Don't have an accout? <span class='hightlight'>Sign Up</span>";

  divBottom.append(elLabel);
  divBottom.append(elInput);
  divBottom.append(btnSubmit);
  divBottom.append(elSignUp);

  form.append(divTop);
  form.append(divBottom);

  return form;
}

function makeSignUp() {}
