# Java Selenium TestNG Automation Framework

A clean and scalable Java Selenium TestNG automation framework designed for UI test automation. This framework supports cross-browser execution (Chrome/Firefox), page object model structure, reporting, logging, and CI/CD compatibility.

---

## **Tech Stack**

* **Java 17+**
* **Selenium WebDriver 4+**
* **TestNG**
* **Maven**
* **Extent / Allure Reports** (optional based on your setup)
* **Log4j / SLF4J logging**
* **Page Object Model (POM)**

---

##  **Project Structure**

```
project-root
│
├── src
│   ├── main
│   │   └── java
│   │       └── pages/              # Page classes
│   │       └── utils/              # Helper utilities
│   │
│   └── test
│       └── java
│           └── tests/              # Test classes
│           └── base/               # Base test setup
│
├── testng.xml                      # Test execution suite
├── pom.xml                         # Maven dependencies
└── README.md                       # Documentation
```

---

##  **Setup Instructions**

### **1. Clone the Repository**

```
git clone <repo-url>
cd project-folder
```

### **2. Install Dependencies**

Maven will automatically download everything:

```
mvn clean install
```

### **3. Configure Browser & Environment**

Update configurations in:

```
src/test/resources/config.properties
```

Example:

```
browser=chrome
environment=qa
baseUrl=https://example.com
```

---

##  **How to Run Tests**

### **Run using the testng.xml file**

```
mvn clean test -DsuiteXmlFile=testng.xml
```

### **Run a specific test class**

```
mvn -Dtest=LoginTest test
```

### **Run with browser parameter**

```
mvn clean test -Dbrowser=firefox
```

---

##  **TestNG Suite (testng.xml)**

Example TestNG suite:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Automation Suite" parallel="false">
    <test name="UI Tests">
        <parameter name="browser" value="chrome" />
        <classes>
            <class name="tests.LoginTest" />
            <class name="tests.RegistrationTest" />
        </classes>
    </test>
</suite>
```

##  **Logs**

All logs will be stored under:

```
target/logs/
```

Uses **Log4j/SLF4J** for detailed execution-level logging.

 any help or enhancements, feel free to reach out!
