package dto;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true )
public class DepartmentDto {
	
	public Long id;
	public String name ;
	
	public List<EmployeeDto> employees;
	
	
	public DepartmentDto(Department department) {
		
		this.id = department.getId();
		this.name = department.getName();
		
	}

}
