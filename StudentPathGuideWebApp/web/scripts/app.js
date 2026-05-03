/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
window.addEventListener("load", () => {
  const main = document.getElementById("main");

  const loginPage = makeLogin();
  const signUpPage = makeSignUpPage();

  console.log(loginPage);
  main.appendChild(loginPage);

  signUpPage.classList.add("hidden");
  main.appendChild(signUpPage);

  const toggleLogin = document.getElementById("toggleLogin");
  const toggleSignUp = document.getElementById("toggleSignUp");

  toggleSignUp.addEventListener("click", () => {
    if (signUpPage.classList.contains("hidden")) {
      loginPage.classList.add("hidden");
      signUpPage.classList.remove("hidden");
    }
  });
  toggleLogin.addEventListener("click", () => {
    if (loginPage.classList.contains("hidden")) {
      loginPage.classList.remove("hidden");
      signUpPage.classList.add("hidden");
    }
  });

  document.getElementById("chat").addEventListener("submit", (e) => {
    e.preventDefault();
    const prompt = document.getElementById("prompt");

    const promptContainer = document.createElement("div");
    promptContainer.classList.add("user_text_container");
    const text = document.createElement("p");

    text.innerText = prompt.value;
    console.log(text.innerText);
    promptContainer.appendChild(text);

    document.querySelector("chat_container").appendChild(promptContainer);
  });
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
  const loginForm = document.createElement("form");
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
  loginForm.classList.add("main_container");
  loginForm.setAttribute("method", "post");
  // loginForm.classList.add("hidden");
  loginForm.action = loginInfo.servlet;
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
  elInput.name = "username";

  elSignUp.innerHTML =
    "Don't have an accout? <span class='hightlight' id='toggleSignUp'>Sign Up</span>";

  divBottom.append(elLabel);
  divBottom.append(elInput);
  divBottom.append(btnSubmit);
  divBottom.append(elSignUp);

  loginForm.append(divTop);
  loginForm.append(divBottom);

  return loginForm;
}

function makeSignUpPage() {
  // MAIN ELEMENTS
  const signUpForm = document.createElement("form");
  const divTop = document.createElement("div");
  const divBottom = document.createElement("div");

  const elTitle = document.createElement("h1");
  const tableUser = document.createElement("table");
  const tableSubjects = document.createElement("table");
  const tableField = document.createElement("table");

  const btnSubmit = document.createElement("button");
  const elLogin = document.createElement("p");

  // CLASSES / ATTRIBUTES
  signUpForm.classList.add("main_container");
  signUpForm.classList.add("info");
  signUpForm.action = "SignUpServlet.do";
  signUpForm.setAttribute("method", "post");
  //signUpForm.classList.add("hidden");

  divTop.classList.add("Welcome_container");
  divBottom.classList.add("login_container");

  elTitle.innerText = "Sign Up";

  tableSubjects.classList.add("subjects-table");

  btnSubmit.textContent = "Sign Up";
  btnSubmit.type = "submit";

  elLogin.innerHTML =
    "Have an account? <span class='hightlight' id='toggleLogin' >Login</span>";

  // -------------------
  // USER INFO TABLE
  // -------------------
  const row1 = document.createElement("tr");
  const row2 = document.createElement("tr");

  const userLabel = document.createElement("label");
  userLabel.innerText = "Username";

  const userInput = document.createElement("input");
  userInput.type = "text";
  userInput.placeholder = "username";
  userInput.name = "username";
  userInput.required = true;

  const gradeLabel = document.createElement("label");
  gradeLabel.innerText = "Grade";

  const gradeInput = document.createElement("input");
  gradeInput.type = "text";
  gradeInput.placeholder = "12";
  gradeInput.name = "grade";
  gradeInput.required = true;

  let td1 = document.createElement("td");
  let td2 = document.createElement("td");

  td1.append(userLabel);
  td2.append(userInput);
  row1.append(td1, td2);

  td1 = document.createElement("td");
  td2 = document.createElement("td");

  td1.append(gradeLabel);
  td2.append(gradeInput);
  row2.append(td1, td2);

  tableUser.append(row1, row2);

  // -------------------
  // SUBJECT TABLE
  // -------------------

  const thead = document.createElement("thead");
  const headRow = document.createElement("tr");

  const th1 = document.createElement("th");
  th1.innerText = "Subject";

  const th2 = document.createElement("th");
  th2.innerText = "Percentage (%)";

  headRow.append(th1, th2);
  thead.append(headRow);

  const tbody = document.createElement("tbody");

  // helper to create subject rows
  function createRow(num) {
    const tr = document.createElement("tr");

    const tdSub = document.createElement("td");
    const tdPerc = document.createElement("td");

    const select = document.createElement("select");
    select.name = "subject" + num;

    const subjects = [
      "IsiZulu Home Language",
      "English FAL",
      "Mathematical Literacy",
      "Mathematics",
      "Life Sciences",
      "Physical Sciences",
      "Accounting",
      "Tourism",
      "Business Studies",
      "Economics",
      "Geography",
      "Computer Applications Technology CAT",
      "Engineering Graphics And Design EGD",
      "Agricultural Sciences",
      "Consumer Studies",
    ];

    subjects.forEach((sub) => {
      const option = document.createElement("option");
      option.value = sub.toLowerCase().replace(" ", "_");
      option.textContent = sub;
      select.append(option);
    });

    const input = document.createElement("input");
    input.type = "number";
    input.name = "perc" + num;
    input.min = 0;
    input.max = 100;
    input.placeholder = "0 - 100";

    tdSub.append(select);
    tdPerc.append(input);

    tr.append(tdSub, tdPerc);

    return tr;
  }

  // create 6 rows
  for (let i = 1; i <= 6; i++) {
    tbody.append(createRow(i));
  }

  tableSubjects.append(thead, tbody);

  // -------------------
  // FIELD TABLE
  // -------------------

  const fieldRow = document.createElement("tr");

  const fieldLabel = document.createElement("label");
  fieldLabel.innerText = "Field";

  const fieldInput = document.createElement("input");
  fieldInput.type = "text";
  fieldInput.name = "field";
  fieldInput.placeholder = "computer sciences";
  fieldInput.required = true;

  const tdF1 = document.createElement("td");
  const tdF2 = document.createElement("td");

  tdF1.append(fieldLabel);
  tdF2.append(fieldInput);

  fieldRow.append(tdF1, tdF2);
  tableField.append(fieldRow);

  // -------------------
  // COMBINE EVERYTHING
  // -------------------

  divTop.append(elTitle);

  divBottom.append(tableUser);
  divBottom.append(tableSubjects);
  divBottom.append(tableField);
  divBottom.append(btnSubmit);
  divBottom.append(elLogin);

  signUpForm.append(divTop);
  signUpForm.append(divBottom);

  return signUpForm;
}
