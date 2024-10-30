package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.input.DepartmentInput;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.TaskRepo;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private TaskRepo taskRepo;
	
	public Optional<Department> findById(Long id) {
		return departmentRepo.findById(id);
		}
	
	public Department insertDepartment(DepartmentInput dept) {
		
		String nameDept = dept.name;
		Long  id = dept.address_id;
		Optional<Department> departmenOpt = departmentRepo.findDepartmentByName(nameDept);
		if (departmenOpt.isPresent())
			throw new  IllegalStateException("The Department is exist");
		
		Department newDepartment = new Department();
		newDepartment.setName(nameDept);
		newDepartment.setAddressId(id);
		
		
		return departmentRepo.save(newDepartment);
	}
	
	public Department update(Department dept) {
		
		Department current = departmentRepo.findById(dept.getId()).get();
	    current.setName(dept.getName());
		return departmentRepo.save(current);
	}
	
	public List<Department> findAll(){
		return departmentRepo.findAll();
	}
	
	@Transactional
	public String deleteDepartment(Long deptId) {
		String msg = null;
		boolean exist = departmentRepo.existsById(deptId);
		if(!exist) {
			msg = String.format("the department with id = %s does not exist ", deptId);
			return msg;
		}
		
		Set<Long> setEmployee = departmentRepo.getALLEmployeeInDepartment(deptId);
		taskRepo.deleteAllTaskEmployee(setEmployee);
		departmentRepo.deleteAllEmployees(deptId);
		departmentRepo.deleteById(deptId);
		msg= String.format("The department with id = %s deleted ", deptId);
		return msg;
			
	}
	
	/*public List<Employee> findByDepartmentId(Long deptId){
		return departmentRepo.findByDepartmentId(deptId);
	}*/


}
