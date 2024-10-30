package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

import jakarta.transaction.Transactional;

@Repository
public interface DepartmentRepo  extends JpaRepository<Department, Long>{
	
	@Transactional
	@Modifying
	@Query("delete from Employee emp where emp.department.id = ?1")
	void deleteAllEmployees(@Param("deptId") Long deptId);
	
	
	@Query("select dept  from Department dept where dept.name = :nameDept")
	Optional<Department>  findDepartmentByName(@Param("nameDept") String nameDept);
	
	
	@Query("select dept from Department dept where dept.addressId = :addressId")
	List<Department> findByAddressId(@Param("addressId") Long addressId);
	
	
	@Query("select emp.id from Employee emp "
			+ "where  emp.department.id = :deptId")
	Set<Long> getALLEmployeeInDepartment(@Param("deptId") Long deptId);
	
	


}
