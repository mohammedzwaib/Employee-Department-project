package dto;

import java.time.LocalDate;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;

public class EmployeeDto {
	
	public String name;
	public double salary;
	public String email;
	public LocalDate dob;
	public String car;
	public Long departmentId;
	public Long addressId;
	public DepartmentDto department;
	
	public EmployeeDto(Employee employee) {
		
		this.name = employee.getName();
		this.salary = employee.getSalary();
		this.email = employee.getEmail();
		this.dob = employee.getDob();
		this.car = employee.getCar();
		this.addressId = employee.getAddressId();
		this.departmentId = employee.getDepartmentId();
		
		}
	
}
