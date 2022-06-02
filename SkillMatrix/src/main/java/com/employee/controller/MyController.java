package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DTO.AdminDto;
import com.employee.DTO.LoginDto;
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





@RestController
@EnableJpaRepositories("com.employee.Repository")
@RequestMapping("/api/auth")
public class MyController {
	
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
    
   
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupDto signUpDto){

        // add check for username exists in a DB
        // add check for email exists in DB
        if(userRepository.existsByCode(signUpDto.getCode())){
            return new ResponseEntity<>("Username is already taken with this employee code!", HttpStatus.BAD_REQUEST);
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
        
        return new ResponseEntity<>("User with Id: "+user.getCode()+" and  name: "+user.getName()+" signed-in successfully!.",  HttpStatus.OK);

    }
    
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        if(userRepository.existsByEmail(loginDto.getEmail())) {
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
        }
        if(userRepository.existsByPassword(loginDto.getPassword())) {
            return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
            }
        return new ResponseEntity<>("User Not Found!.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/Adminsignin")
    public ResponseEntity<String> authenticateAdmin(@RequestBody AdminDto adminDto){
        if(adminRepo.existsByName(adminDto.getName())) {
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
        }
        if(adminRepo.existsByPassword(adminDto.getPassword())) {
            return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
            }
        return new ResponseEntity<>("User Not Found!.", HttpStatus.NOT_FOUND);
    }
    
   
    @GetMapping("/technology")
    public List<Technology> listOfTech(){
	   return technologyRepo.findAll();
    }
    
    @GetMapping("/projects")
    public List<Project> listOfProjects(){
    	return projectRepo.findAll();
    }
    
    @GetMapping("/designation")
    public List<Designation> listOfDesignation(){
    	return designationRepo.findAll();
    }
    

}
