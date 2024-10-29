<h1  align ="center"> Employee Department Company Project  </h1>
<p align ="center">
<a href="Java Url">
   <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
</a>
</p>

----
<p align ="left" >

## Overview

This project, "Employee Department Mapping Project", is a Spring Boot application that demonstrates a one-to-many mapping between Department and Employee entities. In addition to a one-to-many mapping between Title and Department and Title and Employee. In addition to a one-to-many relationship between Employee and EmployeeAttendance entities. In addition to a one-to-many mapping between Employee and Task entities, it provides a set of RESTful API endpoints for creating, retrieving, updating, deleting Titles, Departments, Employees, Tasks, Attendance, and some other operations. This project serves as a basis for managing employee data in specific departments, recording their attendance, and assigning tasks to employees.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven


  
## Dependencies

The E-commerce API Application uses the following dependencies:

- **Spring Boot Starter Data JPA**
  - **Description:** Provides support for JPA (Java Persistence API) and simplifies database access using Spring Data repositories.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```

- **Spring Boot Starter Web**
  - **Description:** Provides support for building web applications, including RESTful APIs.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```

- **MySQL Connector/J (Runtime Dependency)**
  - **Description:** The MySQL JDBC driver for connecting to MySQL databases.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```

- **Project Lombok (Optional)**
  - **Description:** A library that simplifies Java code by reducing boilerplate code, such as getters , setters and Parameterized constructor.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```

- **Spring Boot Starter Test (For Testing)**
  - **Description:** Provides support for testing Spring Boot applications.
  - **Maven Dependency (Test Scope):**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```

- **Springdoc OpenAPI (Swagger UI)**
  - **Description:** Adds Swagger UI for documenting and testing your API endpoints.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.1.0</version>
    </dependency>
    ```

- **Spring Boot Starter Validation**
  - **Description:** Includes validation support for request data binding and response data rendering.
  - **Maven Dependency:**
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    ```
## Flow Date

In the Employee Department Company Project , data flows through various components to handle employee perations. Here's an overview of the data flow:

1.**Employee Entity**:

   - **Controller Layer**

     The `EmployeeController` handles HTTP requests related to employees and routes them to the `EmployeeService`.

     ```java
     //EmployeeController

     @RestController
     @RestMapping("/employee")
     public class EmployeeController{
     
     // Define employee-related endpoints and methods

     }
     ```
     


