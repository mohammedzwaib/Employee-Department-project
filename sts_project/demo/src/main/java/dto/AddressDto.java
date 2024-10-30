package dto;

import java.util.List;

import com.google.gson.JsonObject;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class AddressDto {
	
	public  Long addressNumber;
	public List name;
	public String addressEmployee;
	public String addressDepartment;

}
