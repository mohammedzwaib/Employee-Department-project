package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.input.TaskInput;
import com.example.demo.service.TaskService;

import dto.DepartmentDto;
import dto.EmployeeDto;
import dto.TaskDto;
import dto.pointDto;

@RestController
@RequestMapping("/task")

public class TaskController {
	

	  @Autowired
	  public TaskService taskService;
	  
	  @GetMapping("/{taskId}")
	  public TaskDto getTask(@PathVariable Long taskId){
		  
	    Task task =  taskService.get(taskId);
	    TaskDto taskDto = new TaskDto(task);
	    EmployeeDto employeeDto = new EmployeeDto(task.getEmployee());
	    taskDto.employee = employeeDto;
	    return taskDto;
	    
	      
	    
	  }
	  @PostMapping("/insert")
	  public Task insert(@RequestBody TaskInput taskInput) {
	    
	    return taskService.insert(taskInput);
	  }
	  
	  @PutMapping("/finished/{taskId}")
	  public void finished(@PathVariable Long taskId,
	                    @RequestParam LocalDate finishedDate) {
	    
	    taskService.finishedTask(taskId,finishedDate);
	      
	    }
	  
	  @GetMapping("/getTasks/{isFinished}")
	  public List<TaskDto> getTasks(@PathVariable Boolean isFinished){
		 
		  List<Task> task =  taskService.getTasks(isFinished);
		  List<TaskDto> taskAllDto = new ArrayList<>();
		  
		  for (Task obj : task) {
			  
			  TaskDto taskDto = new TaskDto(obj);
			  taskAllDto.add(taskDto);
		  }
		  
		  return  taskAllDto;	  		  
	  }
	  
	  
	  @GetMapping("/sumPoints")
	  public List<pointDto> sumPoints(){
		  
		  return taskService.sumPoints();
	  }    

}
