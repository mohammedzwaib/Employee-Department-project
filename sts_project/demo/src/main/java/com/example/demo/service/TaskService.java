package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.input.TaskInput;
import com.example.demo.repository.TaskRepo;

import dto.TaskDto;
import dto.pointDto;

@Service
public class TaskService {
	

	  @Autowired
	  private TaskRepo taskRepo;
	  
	  
	    public Task get(Long taskId) {
	      
	      return  taskRepo.findById(taskId).orElseThrow();
	      
	    }
	  
	    
	   
	    public Task insert(TaskInput taskInput) {
	      
	      LocalDate startDate = taskInput.startDate;
	      LocalDate endDate = taskInput.endDate;
	      LocalDate finsishedDate = taskInput.finishedDate;
	      Boolean isFinished = taskInput.isFinsished;
	      String nameTask = taskInput.nameTask;
	      Long points = taskInput.points;
	      Long id = taskInput.employee_id;
	      
	      Task newTask = new Task();
	      newTask.setStartDate(startDate);
	      newTask.setEndDate(endDate);
	      newTask.setFinishedDate(finsishedDate);
	      newTask.setIsFinished(isFinished);
	      newTask.setNameTask(nameTask);
	      newTask.setPoints(points);
	      newTask.setEmployee_id(id);
	      
	      return taskRepo.save(newTask);
	      
	    }
	    
	    public void finishedTask(long taskId , LocalDate finishedDate) {
	      
	     taskRepo.finishedTask(taskId ,finishedDate);
	      
	    }
	    
	    public List<Task> getTasks(Boolean isFinished){
	    	
	    	if(isFinished)
	    		return taskRepo.getFinished();
	    	else
	    		return taskRepo.getNotFinished();
	    	
	    	
	    }
	    
	    public List<pointDto> sumPoints(){
	    	
	    	return taskRepo.sumPoints();
	    	
	    	}
	

}
