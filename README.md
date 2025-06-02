
A robust and scalable automation framework for **LiveGuru** using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and **Allure Reports**. Built for maintainability, modularity, and professional-level test execution and reporting.


## 📖 Overview

This project automates UI testing for the **LiveGuru** e-commerce platform. It leverages industry-standard tools to ensure efficient, reliable, and readable automated test suites.


## ✨ Features

- Page Object Model (POM) design pattern
- Selenium WebDriver for browser automation
- TestNG for test management
- Log4j for logging
- Allure for professional test reporting
- Maven-based lifecycle
- Easily extendable


## 🧰 Tech Stack

| Category         | Tool/Library         |
|------------------|----------------------|
| Language         | Java                 |
| Build Tool       | Maven                |
| Testing Framework| TestNG               |
| Automation Tool  | Selenium WebDriver   |
| Logging          | Log4j                |
| Reporting        | Allure Report        |



## 📁 Project Structure

```
se-maven-liveguru/
│
├── src/
│   ├── main/java/                  # Page Objects, PageUIs and  Utility Classes
│   └── test/java/                  # Test cases
│   └── test/resources/testng.xml   # Test suite configuration                    
├── pom.xml                         # Project dependencies and plugins
```

## ⚙️ Setup & Installation

### Prerequisites

- Java 8 or higher
- Maven 3.6+
- Git
- Allure CLI (for report generation)

### Installation

```bash
git clone https://github.com/tuanpmdev156/se-maven-liveguru.git
cd se-maven-liveguru
mvn clean install
```

---

## 🧪 Running Tests

Run the test suite with Maven:

```bash
mvn clean test
```

---

## 📊 Allure Report

### Step 1: Run tests and generate Allure results

```bash
mvn clean test
```

### Step 2: Serve the Allure report

```bash
allure serve target/allure-results
```

> You can also generate the static report with:
```bash
allure generate target/allure-results --clean -o target/allure-report
```



