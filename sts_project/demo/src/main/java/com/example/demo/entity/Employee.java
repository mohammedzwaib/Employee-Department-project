package com.example.demo.entity;

import java.time.LocalDate;

import java.time.Period;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Hr_employee")
@DynamicUpdate
@DynamicInsert
@Entity
@Data
@Setter
@Getter

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	private Double salary;

	private String email;

	private LocalDate dob;
	
	private String car;

	@Column(name = "department_id")
	private Long departmentId;
	
	@Column(name = "address_id")
	private Long addressId;
	
	
	@OneToMany(mappedBy = "employee" )
	private List<Task> task;
	
	@ManyToOne
	@JoinColumn(name ="address_id" , updatable = false , insertable = false )
	private Address address;


	@ManyToOne
	@JoinColumn( name = "department_id" , insertable = false, updatable = false)
	private Department department;
	@JsonIgnore
	
	

	@Transient
	private Integer age;
	
	public Integer getAge() {
		return Period.between(this.dob , LocalDate.now()).getYears();
	}

	
	
	
	

	}
	

