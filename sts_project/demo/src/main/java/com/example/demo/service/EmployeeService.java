package com.example.demo.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.input.DepartmentAverageSalary;
import com.example.demo.input.DepartmentMaxSalary;
import com.example.demo.input.EmployeeInput;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.repository.EmployeeRepo;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dto.CarDepartmentDto;
import dto.CarDto;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	public Optional<Employee> findById(Long id){
		return employeeRepo.findById(id);
	}

	public Employee insertEmployee(EmployeeInput emp) {
		
		String name = emp.name;
		String email = emp.email;
		Long id = emp.department_id;
		double salary = emp.salary;
		LocalDate dob = emp.dob;
		String car = emp.car;
		Long address_id = emp.address_id;
		
		

		
		Optional<Employee> employeeOpt = employeeRepo.findEmployeeByEmail(email);

		if (!employeeOpt.isEmpty())
			throw new IllegalStateException("The Employee already exist");

		Optional<Department> departmentOpt = departmentRepo.findById(id);
		if (departmentOpt.isEmpty())
			throw new IllegalStateException("The department does not exist");
		
	    Employee newEmployee = new Employee();
	    newEmployee.setName(name);
	    newEmployee.setEmail(email);
	    newEmployee.setSalary(salary);
	    newEmployee.setDob(dob);
	    newEmployee.setDepartmentId(id);
	    newEmployee.setCar(car);
	    newEmployee.setAddressId(address_id);
	    
	  
	   
	    
		return employeeRepo.save(newEmployee);
	}

	
	
	// Get All Employees depend on the number of Department using Jpa
	public List<Employee> findByDepartmentId(Long deptId) {

		return employeeRepo.findByDepartmentId(deptId);

	}
	// Get All Employees depend on the number of Department using Jpql

	public List<Employee> findByDepartmentIdJpql(Long deptId) {
		return employeeRepo.findByDepartmentIdJpql(deptId);
	}

	public String deleteEmployee(long empId) {

		String msg = null;
		boolean exist = employeeRepo.existsById(empId);
		if (exist) 
			msg = String.format("The Employee with id %s deleted ", empId);

		else 
			msg = String.format("The Employee with id %s does not exists ", empId);
		
	    employeeRepo.deleteTaskEmployee(empId);
		employeeRepo.deleteById(empId);
		return msg;

	}

	@Transactional
	public Employee updateEmployee(Long empId, EmployeeInput emp ) {
		
		String name = emp.name.trim();
		String email = emp.email;
		Double salary = emp.salary;
		String car = emp.car.trim();
		Long department_id = emp.department_id;
		
		Employee employee = employeeRepo.findById(empId)
				.orElseThrow(() -> new IllegalStateException("The Employee with id " + empId + " does not exist"));

		if (!name.isEmpty() && !Objects.equals(employee.getName(), name))
			
			employee.setName(name);

		if (email != null && email.length() > 0 && !Objects.equals(employee.getEmail(), email)) {

			Optional<Employee> employeeOptional = employeeRepo.findEmployeeByEmail(email);

			if (employeeOptional.isPresent())
				throw new IllegalStateException("The emial is exist");

			employee.setEmail(email);
		}
		if (salary != null && salary > 0 && !Objects.equals(employee.getSalary(), salary))
			employee.setSalary(salary);


		if (department_id != null 
				&& !Objects.equals(employee.getDepartment().getId(), department_id)) {

			Department department = departmentRepo.findById(department_id).orElseThrow(
					() -> new IllegalStateException("The department " + department_id + " does not exist"));

			employee.setDepartmentId(department_id);	 
		
		}
		
		if  (car != null && car.trim().length() > 0) 

			employee.setCar(emp.car);		

		return employeeRepo.save(employee);

	}

	// Get average salary each department
	public List<DepartmentAverageSalary> getAverageSalaryByDepartment() {
		List<DepartmentAverageSalary> averageSalaries = new ArrayList<>();
	  
	    List<Object[]> result =  employeeRepo.avgSalary();
	    
	    for (Object[] obj : result) {
	    	
	    	DepartmentAverageSalary salary = new DepartmentAverageSalary();
	        salary.setDepartmentName((String) obj[0]);
	        salary.setAverageSalary((Double) obj[1]);
	        averageSalaries.add(salary);
	    }

	    return averageSalaries;
	}
	
	public List<DepartmentMaxSalary> getMaxSalaryByDepartment() {
		
		List<Object[]> result = employeeRepo.maxSalary();
		List<DepartmentMaxSalary> maxSalaries =  new ArrayList<>();
		
		for (Object [] obj : result) {
			
			DepartmentMaxSalary salary = new DepartmentMaxSalary();
			salary.setDepartmentName((String) obj[0]);
			salary.setEmployeeName((String) obj[1]);
			salary.setMaxSalary((Double) obj[2]);
			maxSalaries.add(salary);
			
		}
		return maxSalaries;
	}
	
	
	public CarDepartmentDto getFindCarsInDepartment(Long deptId){
		
		List<CarDto> cars = employeeRepo.findCarsInDepartment(deptId);
		
		CarDepartmentDto carDepartment = new CarDepartmentDto();
		List<String> nameCar = new ArrayList<>();
		cars.forEach(car ->  
						nameCar.add(car.getCars()));
		
		carDepartment.setDepartmentId(deptId);
		carDepartment.setTypeCar(nameCar);
		return carDepartment;
		
	}

}
