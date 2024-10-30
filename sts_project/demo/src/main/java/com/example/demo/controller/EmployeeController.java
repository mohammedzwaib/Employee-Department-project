package com.example.demo.controller;

import java.util.List;



import java.util.Map;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.input.DepartmentAverageSalary;
import com.example.demo.input.DepartmentMaxSalary;
import com.example.demo.input.EmployeeInput;
//import com.example.demo.input.DepartmentAverageSalary;
//import com.example.demo.input.DepartmentMaxSalary;
//import com.example.demo.input.EmployeeInput;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.CarDepartmentDto;
import dto.CarDto;
import dto.DepartmentDto;
import dto.EmployeeDto;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto>  findById(@PathVariable Long id) {
			
		
	
		Optional<Employee> employeeOptional = employeeService.findById(id);
		if(employeeOptional.isPresent()) {
			
			Employee employee = employeeOptional.get();
			EmployeeDto employeeDto = new EmployeeDto(employee);
			DepartmentDto departmentDto = new DepartmentDto(employee.getDepartment());
			employeeDto.department = departmentDto;
			return ResponseEntity.ok(employeeDto);
			
		}
		
	     return ResponseEntity.notFound().build(); 	
		
	}
	
	@PostMapping()
	public Employee insertEmploy(@RequestBody EmployeeInput emp) {
	    
		return employeeService.insertEmployee(emp);
		
	}

	
	
	//Get All Employees depend on the number of Department using Jpql
	
	@GetMapping("/department/jpql/{deptId}")
	public List<Employee> findByDepartmentIdJpql(@PathVariable Long deptId){

		return employeeService.findByDepartmentIdJpql(deptId);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Long empId) {
		return employeeService.deleteEmployee(empId);
	}
	@PutMapping("/updateEmployee/{empId}")
	public Employee updateEmployee(@PathVariable Long empId ,
			                   @RequestBody EmployeeInput emp) {
			              
		return employeeService.updateEmployee(empId , emp);
		
	
	}
	
	@GetMapping("/averageSalaryByDepartment")
	public List<DepartmentAverageSalary> getAverageSalaryByDepartment() {
		
		return employeeService.getAverageSalaryByDepartment();
		}
	
	
	@GetMapping("/maxSalaryByDepartment")
	public List<DepartmentMaxSalary> getMaxSalaryByDepartment(){
		return 
		employeeService.getMaxSalaryByDepartment();
	}
	
	@GetMapping("findCarsInDepartment/{deptId}")
	public CarDepartmentDto getFindCarsInDepartment(@PathVariable Long deptId){
		
		return employeeService.getFindCarsInDepartment(deptId);
		
	}


}
