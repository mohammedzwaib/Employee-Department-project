package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.AddressInput;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.repository.EmployeeRepo;

import dto.AddressDto;
import dto.EmployeeDto;

@Service
public class AddressService {
  
  @Autowired
    private AddressRepo addressRepo;
  
  @Autowired
  private DepartmentRepo departmentRepo;
  
  @Autowired
  private EmployeeRepo employeeRepo;
  
  public Address findById(Long id) {
    return addressRepo.findById(id).orElseThrow();
    }
  
  public Address insert(Long id , AddressInput addressInput) {
    
    String country = addressInput.country;
    String city = addressInput.city;
    Long postal = addressInput.postal;
    
    Address address = new Address(); 
    address.setCountry(country);
    address.setCity(city);
    address.setPostal(postal);

    return addressRepo.save(address);
    
  }
  
  public String delete(Long id) {
    
    boolean exist = addressRepo.existsById(id);
    String msg = null;
    if(exist) {
      
      List<Department> department = departmentRepo.findByAddressId(id);
      List<Employee> employee = employeeRepo.findByAddressId(id);  
      
      for(Department dept : department) {  
        
        dept.setAddressId(null);
        departmentRepo.save(dept);
      }
      
      for(Employee emp : employee) {
        
        emp.setAddressId(null);
        employeeRepo.save(emp);
        
      }
      
      msg  = String.format("The address with %s deleted ", id);
      addressRepo.deleteById(id);
      
    }
    else
    	 msg = String.format("The address with %s not exist " , id);
    	
    return msg;
    
  }
  
  public List<EmployeeDto> getEmployeeSameAddressDepartment() {
    
    return addressRepo.getEmployeeSameAddressDepartment(); 
       
  }
  
  public List<EmployeeDto>  getEmployeeSameNotAddressDepartment(){
	  
	  return addressRepo.getEmployeeSameNotAddressDepartment(); 
	  
  }
  
  public List<EmployeeDto> getEmployeesInAddress(Long addressId){
	  
	  return addressRepo.getEmployeesInAddress(addressId); 
	  
  }
  
}