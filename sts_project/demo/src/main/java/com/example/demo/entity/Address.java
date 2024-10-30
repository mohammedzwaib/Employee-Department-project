package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="address")
@Setter
@Getter

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String city;
	private String country;
	private Long postal;
	
	
	@OneToMany(mappedBy = "address" , 
			cascade = CascadeType.ALL ,
			orphanRemoval = false)
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "address" ,
			   cascade  = CascadeType.ALL ,
			   orphanRemoval = false)
	private List<Department> department;


}
