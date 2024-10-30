package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameTask;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Column(columnDefinition = "boolean default false" )
	private Boolean isFinished;
	
	@Column(name = "finishedDate")
	private LocalDate finishedDate;
	private Long points;
	private Long employee_id;
	

	@ManyToOne
	@JoinColumn(name = "employee_id" , updatable = false , insertable = false)
	private Employee employee;
	
}
