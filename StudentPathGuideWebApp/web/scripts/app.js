/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.addEventListener("load", () => {
  const main = document.getElementById("main");

  const loginPage = makeLogin();
  const signUpPage = makeSignUpPage();

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

const loginInfo = {
  servlet: "LoginServlet.do",
  welcomeText: "Welcome back",
  imgUrl:
    "https://th.bing.com/th/id/R.fbf39144bff5c02898fdc8fd583f84b6?rik=qLhp7D3LhK%2fQgA&pid=ImgRaw&r=0",
};
function makeLogin() {
  const loginForm = document.createElement("form");
  const divTop = document.createElement("div");
  const divBottom = document.createElement("div");
  const elWelcomeText = document.createElement("h1");
  const elLabel = document.createElement("label");
  const elInput = document.createElement("input");
  const elPassword = document.createElement("input");
  const btnSubmit = document.createElement("button");
  const elSignUp = document.createElement("p");
  const elImg = document.createElement("img");
  const imgCont = document.createElement("div");
  const passwordLabel = document.createElement("Label");

  loginForm.classList.add("card");
  loginForm.setAttribute("method", "post");

  loginForm.action = loginInfo.servlet;
  divTop.classList.add("card");
  divTop.classList.add("card_spacing");
  divBottom.classList.add("card");
  elWelcomeText.classList.add("header");
  elWelcomeText.classList.add("text_center");
  elImg.classList.add("login_img");
  elImg.src = loginInfo.imgUrl;
  imgCont.classList.add("login_img_container");
  elWelcomeText.innerText = loginInfo.welcomeText;
  elInput.placeholder = "username";
  elInput.classList.add("input_field");
  btnSubmit.textContent = "Login";
  btnSubmit.classList.add("button_primary");

  passwordLabel.innerText = "Enter Password";
  elPassword.classList.add("input_field");
  elPassword.type = "password";
  elPassword.placeholder = "password";
  elPassword.name = "password";

  imgCont.append(elImg);
  divTop.append(imgCont);
  divTop.append(elWelcomeText);

  elLabel.innerText = "Enter Username";
  elLabel.classList.add("lbl_text");
  elInput.type = "text";
  btnSubmit.type = "submit";
  elInput.name = "username";

  elSignUp.classList.add("text_center");
  elSignUp.innerHTML =
    "Don't have an accout? <span class='highlight' id='toggleSignUp'>Sign Up</span>";

  divBottom.classList.add("df_column");
  divBottom.append(elLabel);
  divBottom.append(elInput);
  divBottom.append(passwordLabel);
  divBottom.append(elPassword);
  divBottom.append(btnSubmit);
  divBottom.append(elSignUp);

  loginForm.append(divTop);
  loginForm.append(divBottom);

  return loginForm;
}

function makeSignUpPage() {
  const signUpForm = document.createElement("form");
  const divTop = document.createElement("div");
  const divBottom = document.createElement("div");

  const elTitle = document.createElement("h1");
  const tableUser = document.createElement("table");
  const tableSubjects = document.createElement("table");
  const tableField = document.createElement("table");

  const btnSubmit = document.createElement("button");
  const elLogin = document.createElement("p");

  const password = document.createElement("input");
  const passwordConfirm = document.createElement("input");

  const passwordLabel = document.createElement("label");
  const passwordLabelConfirm = document.createElement("label");

  passwordLabel.innerText = "Create Password";
  passwordLabelConfirm.innerText = "Confirm Password";
  password.type = "password";
  password.name = "password";
  passwordConfirm.type = "password";
  password.placeholder = "Create Password";
  passwordConfirm.placeholder = "Confirm Password";
  password.classList.add("input_field");
  passwordConfirm.classList.add("input_field");
  password.required = true;
  passwordConfirm.required = true;

  signUpForm.classList.add("card");

  signUpForm.action = "SignUpServlet.do";
  signUpForm.setAttribute("method", "post");

  divTop.classList.add("card");
  divTop.classList.add("card_spacing");
  divBottom.classList.add("card");

  elTitle.innerText = "Sign Up";

  tableSubjects.classList.add("subjects-table");

  btnSubmit.textContent = "Sign Up";
  btnSubmit.type = "submit";
  btnSubmit.classList.add("button_primary");
  btnSubmit.classList.add("max-wid");

  elLogin.classList.add("text_center");
  elLogin.innerHTML =
    "Have an account? <span class='highlight' id='toggleLogin' >Login</span>";

  const row1 = document.createElement("tr");
  const row2 = document.createElement("tr");
  const row3 = document.createElement("tr");
  const row4 = document.createElement("tr");

  const userLabel = document.createElement("label");
  userLabel.innerText = "Username";

  const userInput = document.createElement("input");
  userInput.type = "text";
  userInput.placeholder = "username";
  userInput.name = "username";
  userInput.classList.add("input_field");
  userInput.required = true;

  const gradeLabel = document.createElement("label");
  gradeLabel.innerText = "Grade";

  const gradeInput = document.createElement("input");
  gradeInput.type = "text";
  gradeInput.placeholder = "12";
  gradeInput.name = "grade";
  gradeInput.classList.add("input_field");
  gradeInput.required = true;

  let td1 = document.createElement("td");
  let td2 = document.createElement("td");

  td1.append(userLabel);
  td2.append(userInput);
  row1.append(td1, td2);

  td1 = document.createElement("td");
  td2 = document.createElement("td");

  td1.append(passwordLabel);
  td2.append(password);
  row2.append(td1, td2);

  td1 = document.createElement("td");
  td2 = document.createElement("td");

  td1.append(passwordLabelConfirm);
  td2.append(passwordConfirm);
  row3.append(td1, td2);

  td1 = document.createElement("td");
  td2 = document.createElement("td");

  td1.append(gradeLabel);
  td2.append(gradeInput);
  row4.append(td1, td2);

  const errorMsg = document.createElement("p");
  errorMsg.classList.add("text_center");
  errorMsg.style.color = "red";
  errorMsg.style.fontSize = "0.875rem";
  errorMsg.style.marginTop = "4px";
  tableUser.append(row1, row2, row3, row4);

  const thead = document.createElement("thead");
  const headRow = document.createElement("tr");

  const th1 = document.createElement("th");
  th1.innerText = "Subject";

  const th2 = document.createElement("th");
  th2.innerText = "Percentage (%)";

  headRow.append(th1, th2);
  thead.append(headRow);

  const tbody = document.createElement("tbody");

  function createRow(num) {
    const tr = document.createElement("tr");

    const tdSub = document.createElement("td");
    const tdPerc = document.createElement("td");

    const select = document.createElement("select");
    select.classList.add("input_field");
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
    input.classList.add("input_field");
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

  for (let i = 1; i <= 6; i++) {
    tbody.append(createRow(i));
  }

  tableSubjects.append(thead, tbody);

  const fieldRow = document.createElement("tr");

  const fieldLabel = document.createElement("label");
  fieldLabel.innerText = "Field of Interest";

  const fieldInput = document.createElement("input");
  fieldInput.classList.add("input_field");
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

  divTop.append(elTitle);

  signUpForm.addEventListener("submit", (e) => {
    const error = checkPassword(password, passwordConfirm);

    if (error) {
      e.preventDefault();

      password.style.borderColor = "red";
      passwordConfirm.style.borderColor = "red";

      errorMsg.textContent = error;
    } else {
      password.style.borderColor = "";
      passwordConfirm.style.borderColor = "";
      errorMsg.textContent = "";
    }
  });
  divBottom.classList.add("df_column");
  divBottom.append(tableUser);
  divBottom.append(errorMsg);
  divBottom.append(tableSubjects);
  divBottom.append(tableField);
  divBottom.append(btnSubmit);
  divBottom.append(elLogin);

  signUpForm.append(divTop);
  signUpForm.append(divBottom);

  return signUpForm;
}

function checkPassword(password, passwordConfirm) {
  if (password.value.trim() === "" || passwordConfirm.value.trim() === "") {
    password.style.borderColor = "red";
    passwordConfirm.style.borderColor = "red";

    return "Password field cannot be empty";
  }

  const passLen = password.value.length;
  const conLen = passwordConfirm.value.length;

  if (passLen < 8 || conLen < 8) {
    return "Password must be at least 8 characters";
  }

  const pass = password.value;
  const con = passwordConfirm.value;

  if (pass !== con) {
    return "Passwords don't match";
  }

  const lowerCase = "abcdefghijklmnopqrstuvwxyz";
  const upperCase = lowerCase.toUpperCase();
  const digits = "0123456789";
  const chars = "!@#$%^&*()-_+";

  let containsLower = false;
  let containsUpper = false;
  let containsDigit = false;
  let containsChar = false;

  for (let i = 0; i < pass.length; i++) {
    if (lowerCase.includes(pass[i])) {
      containsLower = true;
    } else if (upperCase.includes(pass[i])) {
      containsUpper = true;
    } else if (digits.includes(pass[i])) {
      containsDigit = true;
    } else if (chars.includes(pass[i])) {
      containsChar = true;
    }
  }

  if (!containsLower) {
    return "Password needs a lowercase letter";
  }

  if (!containsUpper) {
    return "Password needs an uppercase letter";
  }

  if (!containsDigit) {
    return "Password needs a number";
  }

  if (!containsChar) {
    return "Password needs a special character [!@#$%^&*()_+]";
  }

  return null;
}

document.getElementById("chat").addEventListener("submit", (e) => {
  e.preventDefault();

  const messageEL = document.createElement("p");
  const userInput = document.getElementById("prompt");

  messageEL.innerText = userInput.value.trim();
  messageEL.classList.add("user_message", "message");

  container.appendChild(messageEL);
  userInput.value = "";
});
