package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;
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
import com.employee.service.UserService;

@RestController
@EnableJpaRepositories("com.employee.Repository")
@RequestMapping("/api/auth")
public class MyController {
	
    
    @Autowired
    private UserService userService;
    
    
    @PostMapping("/signup")
    public String registerUser(@RequestBody SignupDto signUpDto){

    	return userService.registerUser(signUpDto);
       
    }
    
    @PostMapping("/Adminsignin")
    public String authenticateAdmin(@RequestBody AdminDto adminDto){
    	return userService.adminLogin(adminDto);
    }
    
    
    @GetMapping("/technology")
    public List<Technology> listOfTech(){
	   return userService.getTechnologies();
    }
    
    
    @GetMapping("/projects")
    public List<Project> listOfProjects(){
    	 return userService.getProjects();
    }
    
    
    @GetMapping("/designation")
    public List<Designation> listOfDesignation(){
    	 return userService.getDesignations();
    }
    
    
//    @PostMapping("/signin")
//    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
//        if(userRepository.existsByEmail(loginDto.getEmail())) {
//        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//        }
//        if(userRepository.existsByPassword(loginDto.getPassword())) {
//            return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//            }
//        return new ResponseEntity<>("User Not Found!.", HttpStatus.NOT_FOUND);
//    }
    
    

}
