# Student Path Guide — INT Project

> Career and course guidance system for South African high school students.

Student Path Guide is a Java-based web application that helps Grade 10–12 learners make informed decisions about their future careers and university pathways. Built as an Integration Project (INT) at Tshwane University of Technology.

> **Note:** This is the original INT project version (Java backend). The evolved full-stack version with React, PostgreSQL, and AI chat is at [E-scert/StudentPathGuide](https://github.com/E-scert/StudentPathGuide).

---

## Table of contents

- [Why it was built](#why-it-was-built)
- [Features](#features)
- [Project structure](#project-structure)
- [Tech stack](#tech-stack)
- [Getting started](#getting-started)
- [Usage](#usage)
- [Contributors](#contributors)

---

## Why it was built

Many students — especially those from underprivileged backgrounds — lack access to accurate and structured information about career options, university requirements, and subject choices. This often leads to poor decisions that affect their long-term opportunities.

Student Path Guide bridges that gap by giving students the tools and guidance they need to confidently choose a career path that aligns with their interests and academic performance.

---

## Features

- **Course finder** — helps students discover courses they qualify for based on their subjects and results
- **AI chat assistant** — provides guidance, answers questions, and explains career options in a simple, accessible way

---

## Project structure

```
INT-Project/
├── StudentPathGuideWebApp/   # Java web application (main project)
├── docs/                     # Project documentation and diagrams
├── .gitignore
└── README.md
```

---

## Tech stack

| Technology | Role |
|---|---|
| Java | Backend logic — APS calculation, course matching, routing |
| HTML & CSS | Frontend structure and styling |
| JavaScript | Frontend interactivity |

---

## Getting started

### Prerequisites

- Java JDK 11 or higher
- Apache NetBeans or any Java-compatible IDE (e.g. IntelliJ IDEA, Eclipse)
- Apache Tomcat (for running the web application)

### 1. Clone the repository

```bash
git clone https://github.com/E-scert/INT-Project.git
cd INT-Project
```

### 2. Open in your IDE

Open the `StudentPathGuideWebApp` folder as a project in NetBeans or your preferred Java IDE.

### 3. Configure the server

Set up an Apache Tomcat server in your IDE and deploy the project to it.

### 4. Run the application

Start the Tomcat server and navigate to:

```
http://localhost:8080/StudentPathGuideWebApp
```

---

## Usage

1. Open the application in your browser
2. Enter your subjects and mark percentages
3. The system calculates your APS score and returns matching courses
4. Explore recommended courses and universities
5. Use the AI assistant to ask questions about careers and study paths

---

## Contributors

- **E-scert** — [github.com/E-scert](https://github.com/E-scert)

---

## Related

- [StudentPathGuide v3.0](https://github.com/E-scert/StudentPathGuide) — the evolved version built with React, Node.js, PostgreSQL, and Google Gemini AI
