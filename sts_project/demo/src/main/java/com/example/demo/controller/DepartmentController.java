package com.example.demo.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.input.DepartmentInput;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.DepartmentDto;
import dto.EmployeeDto;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	

	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable Long id) throws JsonProcessingException {
		
		Optional<Department> departmentOptional = departmentService.findById(id);
		if(departmentOptional.isPresent()) {
			
			Department department = departmentOptional.get();
			DepartmentDto departmentDto = new DepartmentDto(department);
			List<Employee> allEmployees = department.getEmployees();
			
			List<EmployeeDto> allDtoEmployees = new ArrayList<>();
			
			for(Employee employee : allEmployees) {
				
				EmployeeDto employeeDto = new EmployeeDto(employee);	
				allDtoEmployees.add(employeeDto);
				
			}
			
			
			departmentDto.employees = allDtoEmployees;
			String json = mapper.writeValueAsString(departmentDto);

			return ResponseEntity.ok(json);
			
		}
		return new ResponseEntity<String>("The department not exist" , HttpStatusCode.valueOf(404));		
	}
	
	@PostMapping()
	public Department insertDepartment(@RequestBody DepartmentInput dept) {
		return departmentService.insertDepartment(dept);	
		
	}
	
	@PutMapping()
	public Department update(@RequestBody Department dept) {
		return departmentService.update(dept);
		
	}
	
	@GetMapping()
	public List<Department> findAll(){
		
		return departmentService.findAll();
		
	}
	
	@DeleteMapping("/deleteDepartment/{deptId}")
	public String deleteDepartment(@PathVariable Long deptId) {
		return departmentService.deleteDepartment(deptId);
	}
	
	

}
