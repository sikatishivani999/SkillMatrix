package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	

	private String technologyCode;
	
	public Technology(String technologyCode) {
		this.technologyCode = technologyCode;
	}
	
	private String technologyName;
}
