package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;

import dto.EmployeeDto;

@Repository
public interface AddressRepo  extends JpaRepository<Address ,Long> {

    String query = "select emp from Employee emp "
            + "inner join emp.department dept "
            + "inner join dept.address ";
	

	
	@Query(query  + "where emp.addressId = dept.addressId")
	List<EmployeeDto> getEmployeeSameAddressDepartment();

    @Query(query + "where emp.addressId != dept.addressId")
    List<EmployeeDto> getEmployeeSameNotAddressDepartment();
    
    
    
    @Query("select emp from Employee emp "
  		+ " where emp.addressId = :addressId ")
    List<EmployeeDto> getEmployeesInAddress(@Param("addressId") Long addressId);
  

}