package com.employee.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.DTO.AdminDto;
import com.employee.DTO.SignupDto;
import com.employee.Repository.AdminRepository;
import com.employee.Repository.DesignationRepository;
import com.employee.Repository.ProjectRepository;
import com.employee.Repository.TechnologyRepository;
import com.employee.Repository.UserRepository;
import com.employee.model.Designation;
import com.employee.model.Project;
import com.employee.model.Technology;
import com.employee.model.User;

import com.employee.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AdminRepository adminRepo;
    
    @Autowired
    private TechnologyRepository technologyRepo;
    
    @Autowired
    private ProjectRepository projectRepo;
    
    @Autowired
    private DesignationRepository designationRepo;

	@Override
	public List<User> getalluseers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Technology> getTechnologies() {
		return technologyRepo.findAll();
	}

	

	@Override
	public List<Designation> getDesignations() {
		return designationRepo.findAll();
	}

	@Override
	public List<Project> getProjects() {
		return projectRepo.findAll();
	}


	@Override
	public String registerUser(SignupDto signUpDto) {
		if(userRepository.existsByCode(signUpDto.getCode())){
            return "Username is already taken with this employee code!";
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setCode(signUpDto.getCode());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        
        Designation designation = designationRepo.findByDesigantion(signUpDto.getDesignation());
		user.setDesignation(new Designation(designation.getId()));
		
        user.setExprience(signUpDto.getExprience());
        
        Project project = projectRepo.findByProject(signUpDto.getProject());
		user.setProject(new Project(project.getId()));
       
        userRepository.save(user);
        
        return "User with Id: "+user.getCode()+" and  name: "+user.getName()+" signed-in successfully!.";
	}


	@Override
	public String adminLogin(AdminDto adminDto) {
		if(adminRepo.existsByName(adminDto.getName())) {
	       
	        if(adminRepo.existsByPassword(adminDto.getPassword())) {
	            return "User signed-in successfully!.";
	            }
		}
	        return "User Not Found!.";	}

		

}
