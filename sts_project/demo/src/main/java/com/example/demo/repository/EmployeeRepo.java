package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.CarDto;
import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee, Long>{
	
	List<Employee> findByDepartmentId(@Param("deptId") Long  deptId);
	
	
	@Query("select emp from Employee emp "
			+ " join fetch emp.department dept  where dept.id = :deptId")
	List<Employee> findByDepartmentIdJpql(Long deptId);
	
	@Query("select emp from Employee emp where emp.email = :email")
	Optional <Employee> findEmployeeByEmail(@Param("email") String email);
	
	
	@Query("SELECT dept.name, AVG(emp.salary) FROM Employee emp "
			+ "JOIN emp.department dept GROUP BY dept.id")
	List<Object[]> avgSalary();
	
	
	/*get name of department  , name of employee and salary 
	for employee that has max salary in each department*/  
	
	@Query("select dept.name , emp.name , max(emp.salary) "
			+ "from Employee emp join emp.department dept "
			+ "group by dept.id")
	List<Object[]> maxSalary();

	
	
	@Query("SELECT new dto.CarDto(emp.car) " +
			"FROM Employee emp WHERE emp.departmentId = :deptId ")
	List<CarDto> findCarsInDepartment(@Param("deptId") Long deptId);
	
	@Query("select emp from Employee emp where emp.addressId = :addressId")
	  List<Employee> findByAddressId(@Param("addressId") Long addressId);

    
	@Transactional
	@Modifying
	@Query("delete from Task where employee_id = :empId")
	void deleteTaskEmployee(@Param("empId") Long empId);
	

}
