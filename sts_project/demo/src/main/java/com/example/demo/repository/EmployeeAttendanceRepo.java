package com.example.demo.repository;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.time.LocalTime;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeAttendance;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeAttendanceRepo  extends JpaRepository<EmployeeAttendance, Long>{
	
	
	  @Query("select emp.id from EmployeeAttendance emp "
	  		+ " where emp.employee.id = :empId "
	  		+ " and  date(emp.entrytime) = :currentDate") 
	   Long  getIdAttendance (Long empId  , LocalDate currentDate);

	  @Transactional
	  @Modifying
	  @Query("update EmployeeAttendance emp "
	  		+ "  set emp.exittime =  current_timestamp()  ,"
	  		+ "  emp.num_hours = abs(timestampdiff(second, emp.exittime , emp.entrytime)) "
	  		+ "  where emp.id = :idAttendence")
	 int setExitTime(Long idAttendence);
	  
	  @Query("select  denc.employee_id , emp.name  , dept.name , "
	  		+ " concat(count(denc.id)  , ' days ' , "
	  		+ " time_format(sec_to_time(sum(denc.num_hours)) , '%H hours %i minutes %s seconds')) " 
	  		+ " from EmployeeAttendance denc "
	  		+ " inner join denc.employee emp "
	  		+ " inner join emp.department dept "
	  		+ " group by denc.employee_id , year(denc.entrytime) ,month(denc.entrytime) ")
	  List<Object[]> getTimePeriod();
	  
	  
	  @Query("select e "
	  		+ " from EmployeeAttendance  e "
	  		+ " where e.employee_id = :empId and date(e.entrytime) between :startTime and  :endTime")
	  
	  List<EmployeeAttendance> getTimePeriodBetweenTowTimes(Long empId , LocalDate startTime , LocalDate endTime);	  
	  
	  
      
	  
	  
	  

}
