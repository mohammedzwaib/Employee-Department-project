package com.example.demo.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeAttendance;
import com.example.demo.input.DepartmentInput;
import com.example.demo.input.EmployeeAttendanceInput;
import com.example.demo.input.TimePeriodBetweenTowTimes;
import com.example.demo.input.TimePeriodForEmployee;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.repository.EmployeeAttendanceRepo;
import com.example.demo.repository.EmployeeRepo;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class EmployeeAttendanceService {
	
	@Autowired
    private EmployeeAttendanceRepo employeeAttendanceRepo;
	
	public EmployeeAttendance findById(Long id) {
		return employeeAttendanceRepo.findById(id).orElseThrow();
		}
	
	public EmployeeAttendance logIn(Long empId) {
		
		Timestamp currentDate = new Timestamp(new Date().getTime());
		EmployeeAttendance EmpAtt =  new EmployeeAttendance();
        EmpAtt.setLogIn(empId  , currentDate);
		return employeeAttendanceRepo.save(EmpAtt);
	}

	public int  logOut(Long empId) {
	
		LocalDate currentDate = LocalDate.now();
		Long  idAttendance =  employeeAttendanceRepo.getIdAttendance(empId ,  currentDate );
	    return employeeAttendanceRepo.setExitTime(idAttendance) ;
	  	
}
	public List<TimePeriodForEmployee> getTimePeriodForEmployee(){
		
		List<TimePeriodForEmployee> timePeriodAll = new ArrayList<>();
		List<Object[]> result = employeeAttendanceRepo.getTimePeriod();
		
		for (Object[] obj : result) {
			
			TimePeriodForEmployee timePeriod = new TimePeriodForEmployee();
			timePeriod.setEmployee_id((Long) obj[0]);
			timePeriod.setName_employee((String) obj[1]);
			timePeriod.setName_department((String) obj[2]);
			timePeriod.setTotal_time((String) obj[3]);
			
			timePeriodAll.add(timePeriod);		
			
		}
		return timePeriodAll;
		
	}
	
	public List<TimePeriodBetweenTowTimes> getTimePeriodBetweenTowTimes(Long empId ,
																	    LocalDate startTime , 
																	    LocalDate endTime){
	
		List<TimePeriodBetweenTowTimes> timePeriodForAll = new ArrayList<>();
		List<EmployeeAttendance> result = employeeAttendanceRepo.getTimePeriodBetweenTowTimes(empId ,startTime , endTime );
		System.out.println("Result = "+result);
		
		for ( EmployeeAttendance obj : result ) {
			
			TimePeriodBetweenTowTimes timePeriod = new TimePeriodBetweenTowTimes();
			
			timePeriod.setEmployee_id(obj.getEmployee_id());
			timePeriod.setStartTime(obj.getEntrytime());
			timePeriod.setEndTime(obj.getExittime());
			timePeriod.setNum_hours(obj.getNum_hours());
			
			timePeriodForAll.add(timePeriod);
		}
		
		return timePeriodForAll;
						
		}

}
