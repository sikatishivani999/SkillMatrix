package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
public class User {
	

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "employee_id")
	private String code;
	
	private String email;
	
	private String password;
	
	private String designation;
	
	private String exprience;
	
	public User(int id, String name, String code, String email, String password, String designation, String exprience,
			String project) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.email = email;
		this.password = password;
		this.designation = designation;
		this.exprience = exprience;
		this.project = project;
	}

	private String project;

	public User(int i) {
		super();
		// TODO Auto-generated constructor stub
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
