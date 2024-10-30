package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;

import dto.pointDto;
import jakarta.transaction.Transactional;

@Repository
public interface TaskRepo  extends JpaRepository<Task , Long>{
	
	@Transactional
	@Modifying
	@Query("update Task  "
			+ " set finishedDate = :finishedDate ,"
			+ " isFinished = true "   
			+ " where id = :taskId")
	void finishedTask( @Param("taskId") Long taskId , @Param("finishedDate") LocalDate finishedDate );	
	
	@Query("select task from Task task "
			+ "where task.isFinished = true "
			+ " and task.finishedDate is not null ")
	List<Task> getFinished();
	
	@Query("select new dto.pointDto(employee_id , sum(points)) "
			+ " from Task "
			+ " where  isFinished = true and finishedDate is not null "
			+ " group by employee_id ")
	List<pointDto> sumPoints();
	
	@Query("select task from Task task "
			+ "where task.isFinished = false "
			+ " and task.finishedDate is null ")
	List<Task> getNotFinished();
	
	@Modifying
	@Query("delete from Task where id in :setEmployees")
	void deleteAllTaskEmployee(@Param("setEmployees") Set <Long> setEmployees);
	
	
}
