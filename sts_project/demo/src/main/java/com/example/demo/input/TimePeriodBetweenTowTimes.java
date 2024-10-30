package com.example.demo.input;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class TimePeriodBetweenTowTimes {
	
	private Long employee_id;
	private Timestamp startTime ;
	private Timestamp endTime;
	private Double num_hours;
	
	
	
    private static SimpleDateFormat dateFormat = 
    		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public void setStartTime(Timestamp startTime) {
		
		this.startTime = Timestamp.valueOf(dateFormat.format(startTime));
	}
	
	public void setEndTime(Timestamp endTime) {
		
		this.endTime = Timestamp.valueOf(dateFormat.format(endTime));
	}

}
