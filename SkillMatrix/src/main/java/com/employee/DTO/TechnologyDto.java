package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class TechnologyDto {
	
	private int id;
	
	private String name;
	
	private String code;
	
	private String designation;
	
	private String project;
	
	private String technology;
	
	private String rating;

}
