package com.employee.service;

import java.util.List;

import com.employee.DTO.AdminDto;
import com.employee.DTO.SignupDto;
import com.employee.model.Designation;
import com.employee.model.Project;
import com.employee.model.Technology;
import com.employee.model.User;




public interface UserService {
	
	public List<User> getalluseers();
	
	public String registerUser(SignupDto signUpDto);
	
	public List<Technology> getTechnologies();
	
//	public boolean addtechnoandrating(List<TechnologyDto> technologyDto);
	
	public List<Designation> getDesignations();

	public List<Project> getProjects(); 
	
	public String adminLogin(AdminDto adminDto);
}
