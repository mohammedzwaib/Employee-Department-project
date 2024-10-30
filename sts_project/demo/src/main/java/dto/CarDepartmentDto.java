package dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CarDepartmentDto {
	
	private Long departmentId;
	private List<String> typeCar;

}
