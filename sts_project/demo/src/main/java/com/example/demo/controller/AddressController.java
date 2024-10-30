package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.AddressInput;
import com.example.demo.service.AddressService;

import dto.AddressDto;
import dto.EmployeeDto;


@RestController
@RequestMapping("/address")
public class AddressController {
  
  @Autowired
  public AddressService addressService;
  
  @GetMapping("/{id}")
  public Address get(@PathVariable Long id) {
    
    return addressService.findById(id);
  }
  
  @PostMapping("/insert/{id}")
  public Address insert(@PathVariable Long id ,
              @RequestBody AddressInput addressInput) {
    
    return addressService.insert(id , addressInput);  
    
  }
  
  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    
    return addressService.delete(id);
    
  }
  
  @GetMapping("/getEmployeeSameAddressDepartment")
  public List<EmployeeDto> getEmployeeSameAddressDepartment() {
    
    return addressService.getEmployeeSameAddressDepartment();
    
  }
  
  @GetMapping("/getEmployeeNotSameAddressDepartment")
  public List<EmployeeDto>  getEmployeeSameNotAddressDepartment() {
    
    return addressService.getEmployeeSameNotAddressDepartment();
    
  }
  
  @GetMapping("/getEmployeesInAddress/{addressId}")
  public List<EmployeeDto> getEmployeesInAddress(@PathVariable Long addressId){	  
	  
	 return addressService.getEmployeesInAddress(addressId);
	    
  }

}