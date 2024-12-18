<h1  align ="center"> Employee Management System with Spring Boot </h1>
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

     - **Service Layer**

     The `EmployeeService` contains business logic and interacts with the `EmployeeRepository` to perform CRUD operations on employee data.

     ```java
     // EmployeeService.java

     @Service
     public class EmployeeService {
         // Implement employee-related service methods
     }
     ```

   - **Repository Layer**

     The `EmployeeRepository` manages data access to the employee entity using Spring Data JPA.

     ```java
     // EmployeeRepository.java

     @Repository
     public interface EmployeeRepository extends JpaRepository<Employee, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Employee Entity**

     The `Employee` entity represents the structure of employee data in the database.

     ```java
     // Employee.java (Employee Entity)

     @Entity
     public class Employee {
         // Define employee attributes, getters, setters, etc.
     }
     ```

2- **Department Entity**:

  -**Controller Layer**

   The `DepartmentController` handles HTTP requests related to addresses and routes them to the `DepartmentService`.

   ```java

     //DepartmentControllerr

     @RestController
     @RestMapping("/department")
     public class DepartmentController{
     
     // Define department-related endpoints and methods

     }
   ```

   - **Service Layer**

     The `DepartmentService` contains business logic and interacts with the `DepartmentRepository` to perform CRUD operations on department data.

     ```java
     // DepartmentService.java

     @Service
     public class DepartmentService {
         // Implement department-related service methods
     }
     ```

   - **Repository Layer**

     The `DepartmentRepository` manages data access to the department entity using Spring Data JPA.

     ```java
     // DepartmentRepository.java

     @Repository
     public interface DepartmentRepository extends JpaRepository<Department, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Department Entity**

     The `Department` entity represents the structure of employee data in the database.

     ```java
     // Departmentv.java (Employee Entity)

     @Entity
     public class Department {
         // Define employee attributes, getters, setters, etc.
     }
     ```


  
3- **Address Entity**:

  -**Controller Layer**

   The `AddressController` handles HTTP requests related to addresses and routes them to the `AddressService`.

   ```java

     //AddressControllerr

     @RestController
     @RestMapping("/address")
     public class AddressController{
     
     // Define department-related endpoints and methods

     }
   ```

   - **Address Layer**

     The `AddressService` contains business logic and interacts with the `AddressRepository` to perform CRUD operations on department data.

     ```java
     // AddressService.java

     @Service
     public class AddressService {
         // Implement Address-related service methods
     }
     ```

   - **Repository Layer**

     The `AddressRepository` manages data access to the department entity using Spring Data JPA.

     ```java
     // AddressRepository.java

     @Repository
     public interface AddressRepository extends JpaRepository<Address, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Address Entity**

     The `Address` entity represents the structure of employee data in the database.

     ```java
     // Address.java (Address Entity)

     @Entity
     public class Address {
         // Define address attributes, getters, setters, etc.
     }
     ```

  
4- **Task Entity**:

  -**Controller Layer**

   The `TaskController` handles HTTP requests related to addresses and routes them to the `TaskService`.

   ```java

     //TaskControllerr

     @RestController
     @RestMapping("/task")
     public class TaskController{
     
     // Define department-related endpoints and methods

     }
   ```

   - **Task Layer**

     The `TaskService` contains business logic and interacts with the `TaskRepository` to perform CRUD operations on department data.

     ```java
     // TaskService.java

     @Service
     public class TaskService {
         // Implement Task-related service methods
     }
     ```

   - **Repository Layer**

     The `TaskRepository` manages data access to the task entity using Spring Data JPA.

     ```java
     // TaskRepository.java

     @Repository
     public interface TaskRepository extends JpaRepository<Task, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Task Entity**

     The `Task` entity represents the structure of task data in the database.

     ```java
     // Task.java (Task Entity)

     @Entity
     public class Task {
         // Define task attributes, getters, setters, etc.
     }
     ```
     
  
5- **EmployeeAttendance Entity**:

  -**Controller Layer**

   The `EmployeeAttendanceController` handles HTTP requests related to employeeAttendance and routes them to the `EmployeeAttendanceService`.

   ```java

     //EmployeeAttendanceControllerr

     @RestController
     @RestMapping("/employeeAttendance")
     public class EmployeeAttendanceController{
     
     // Define employeeAttendance-related endpoints and methods

     }
   ```

   - **EmployeeAttendance Layer**

     The `EmployeeAttendanceService` contains business logic and interacts with the `EmployeeAttendanceRepository` to perform CRUD operations on department data.

     ```java
     // EmployeeAttendanceService.java

     @Service
     public class EmployeeAttendanceService {
         // Implement EmployeeAttendance-related service methods
     }
     ```

   - **Repository Layer**

     The `TaskRepository` manages data access to the task entity using Spring Data JPA.

     ```java
     // EmployeeAttendanceRepository.java

     @Repository
     public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **EmployeeAttendance Entity**

     The `EmployeeAttendance` entity represents the structure of task data in the database.

     ```java
     // Task.java (EmployeeAttendance Entity)

     @Entity
     public class EmployeeAttendance {
         // Define task attributes, getters, setters, etc.
     }
     ```

## Deseign Table
   The project's database design includes tables for employees and addresses, each with specific fields. This design ensures data integrity and organized storage.

### Employee Table

|Column Name | Data Type | Description                   |
|------------ |-----------|------------------------------|
|   id        |    BIGINT (Primary Key) | Unique identifier for each employee | 
|   name      |    VARCHAR(255) | Name name of the employee                                    
|   email     |    VARCHAR(255) | Email email of the employee    |
|   dob       |  DATE      | Dob employee's date of birth       |
|  salary     |  DOUBLE   | Salary employee of salary             |
|  car        |  VARCHAR(255) | Car employee of car type       |
|department_id|  BIGINT (Foreign Key) | Department ID associated with the employee    |
| address_id  | BIGINT (Foreign Key) |  Address ID associated with the employee        |


### Department Table 

|Column Name | Data Type | Description                   |
|------------ |-----------|------------------------------|
|   id        |    BIGINT (Primary Key) | Unique identifier for each department | 
|   name      |    VARCHAR(255) | Name name of the department    |                                
| address_id  | BIGINT (Foreign Key)|   Address ID associated with the department        |


### Address Table 
 
| Column Name | Data Type   | Description                            |
| ----------- | ----------- | -------------------------------------- |
| id          | BIGINT (Primary Key) | Unique identifier for each address    |
| city        | VARCHAR(255) | City where the address is located      |
| country      | VARCHAR(255) | Country or region of the address         |
| postal     | VARCHAR(20)  | Postal code or ZIP code of the address |


### Task Table 

| Column Name | Data Type   | Description                            |
| ----------- | ----------- | -------------------------------------- |
| id          | BIGINT (Primary Key) | Unique identifier for each task    |
| start_date  | DATE    | Start_Date date start task       |
| end_date    | DATE    | End_Date date end task       |
|finished_date| DATE    | Finished Date  date the task was completed      |
| is_finished | TINYINT(1)  | Task tash is finished or not  |
|   name      |    VARCHAR(255) | Name name of the task    |
| points          | BIGINT     |Points The number of points an employee earns when completing a task|
| employee_id  | BIGINT (Foreign Key) |   Employee ID associated with the task        |

### Employee Attendance Table 

| Column Name | Data Type   | Description                            |
| ----------- | ----------- | -------------------------------------- |
| id          | BIGINT (Primary Key) | Unique identifier for each attendance    |
| entrytime   |  TIMEDATE    | EntryTime employee entry time to the company     |
| exittime    |  TIMEDATE    | ExitTime employee exit time to the company     |
| num_hours    | DOUBLE    | Num_Hours   Number of hours an employee works during the day  |
| is_finished | TINYINT(1)  | Task tash is finished or not  |
| employee_id  | BIGINT (Foreign Key) |   Employee ID associated with the employeeAttendanc        |


## Data Structures

The project utilizes the following data structures to represent employees and address data:

#### Employee Class

The `Employee` class defines the structure for employee data and includes fields such as `id`, `name`,  `salary` ,  `email` ,  `dob` ,`car` ,  a reference to the associated `Department ` 
 and a reference to the associated `Address`.

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	private Double salary;

	private String email;

	private LocalDate dob;
	
	private String car;

	@Column(name = "department_id")
	private Long departmentId;
	
	@Column(name = "address_id")
	private Long addressId;
	
	
	@OneToMany(mappedBy = "employee" )
	private List<Task> task;
	
	@ManyToOne
	@JoinColumn(name ="address_id" , updatable = false , insertable = false )
	private Address address;


	@ManyToOne
	@JoinColumn( name = "department_id" , insertable = false, updatable = false)
	private Department department;
	@JsonIgnore
	
	
}
```
#### ArrayList Usage

ArrayLists can be used to represent lists of items in your application. For example, you can use an ArrayList to represent a list of tasks with their associated  employee.
and you can use an ArrayList to represent a list of employee with their associated  department.


#### Department Class

The `Department` class defines the structure for address data and includes fields such as `id`, `name`, `country` and  a reference to the associated `Address` 

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hr_department")
public class Department {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name = "address_id")
	private Long addressId;	
	

	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
	@ManyToOne
	@JoinColumn(name = "address_id" , updatable = false , insertable = false )
	private Address address;

	

}

```

#### Address Class

The `Address` class defines the structure for address data and includes fields such as `id`, `city`, `country`, `postal`

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String city;
	private String country;
	private Long postal;
	
	
	@OneToMany(mappedBy = "address" , 
			cascade = CascadeType.ALL ,
			orphanRemoval = false)
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "address" ,
			   cascade  = CascadeType.ALL ,
			   orphanRemoval = false)
	private List<Department> department;


}
```

#### Task Class

The `Task` class defines the structure for address data and includes fields such as `id`, `nameTask`, `startDate`, `endDate` ,  `isFinished`, `finishedDate` , `points`

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameTask;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Column(columnDefinition = "boolean default false" )
	private Boolean isFinished;
	
	@Column(name = "finishedDate")
	private LocalDate finishedDate;
	private Long points;
	private Long employee_id;
	

	@ManyToOne
	@JoinColumn(name = "employee_id" , updatable = false , insertable = false)
	private Employee employee;
	
}
```

#### Task Class

The `Task` class defines the structure for address data and includes fields such as `id`, `entrytime`, `exittime`, `num_hours` and  a reference to the associated `ُEmployee` 

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private Timestamp entrytime;

	private Timestamp exittime;
	
	private Double num_hours;
	
	private Long employee_id;

	@ManyToOne
	@JoinColumn(name = "employee_id" , insertable = false , updatable = false)
	
	private Employee employee;
	
	public void setLogIn(Long employee_id , Timestamp  currentDate) {
		
		this.entrytime = currentDate;
		this.setEmployee_id(employee_id);
		
	}	
}
```












     
     


