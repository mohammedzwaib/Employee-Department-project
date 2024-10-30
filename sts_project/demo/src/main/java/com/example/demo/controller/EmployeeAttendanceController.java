package com.example.demo.controller;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeAttendance;
import com.example.demo.input.EmployeeAttendanceInput;
import com.example.demo.input.TimePeriodBetweenTowTimes;
import com.example.demo.input.TimePeriodForEmployee;
import com.example.demo.service.EmployeeAttendanceService;

@RestController
@RequestMapping("/employeeAttendance")
public class EmployeeAttendanceController {
	
	@Autowired
	private EmployeeAttendanceService employeeAttendanceService; 
	
	
	
	@GetMapping()
	public EmployeeAttendance findById(@PathVariable Long id) {
		return employeeAttendanceService.findById(id);
		
	}
	
	@PostMapping("logIn/{empId}")
	public EmployeeAttendance  logIn(@PathVariable Long empId) {
		
		return employeeAttendanceService.logIn(empId);	
		
	}
	
	@PostMapping("logOut/{empId}")
	public String   LogOut(@PathVariable Long empId) {
		  boolean success = employeeAttendanceService.logOut(empId) > 0;
		  if(success)
		    	return "Sucess Log out";
		    return "Failed Log out ";
	}
	
	@GetMapping("timePeriodForEmployee")
	public List<TimePeriodForEmployee>  getTimePeriodForEmployee() {
		
		return employeeAttendanceService.getTimePeriodForEmployee();
	}
	
    @GetMapping("getEmployeeAttendanceBetweenTowTimes/{empId}")
    public List<TimePeriodBetweenTowTimes> getAttBetweenTowTimes(@PathVariable Long empId,
    															 @RequestParam LocalDate startTime ,
    															 @RequestParam LocalDate entTime) {
    	  	

       return employeeAttendanceService. getTimePeriodBetweenTowTimes(empId, startTime , entTime);
    }
    	
    }
    		                                              
		

	
	
	
	


