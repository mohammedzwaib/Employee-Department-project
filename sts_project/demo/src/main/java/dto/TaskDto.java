package dto;

import java.time.LocalDate;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Task;

public class TaskDto {
	
	public Long id;
	public LocalDate startDate;
	public LocalDate endDate;
	public LocalDate finishedDate;
	public String nameTask;
	public Long employee_id;
	public Boolean isFinished;
	public Long points;
	public EmployeeDto employee;
	
	public TaskDto(Task task ) {
		
		this.id = task.getId();
		this.startDate = task.getStartDate();
		this.endDate = task.getEndDate();
		this.finishedDate = task.getFinishedDate();
		this.nameTask = task.getNameTask();
		this.isFinished = task.getIsFinished();
		this.employee_id = task.getEmployee_id();
		this.points = task.getPoints();
		
	}
	

}
