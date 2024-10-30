package com.example.demo.entity;

//import java.security.Timestamp;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class EmployeeAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private Timestamp entrytime;

	private Timestamp exittime;
	
	private Double num_hours;
	
	private Long employee_id;

	@ManyToOne
	@JoinColumn(name = "employee_id" , insertable = false , updatable = false)
	
	private Employee employee;
	
	public void setLogIn(Long employee_id , Timestamp  currentDate) {
		
		this.entrytime = currentDate;
		this.setEmployee_id(employee_id);
		
	}
		
	
}
