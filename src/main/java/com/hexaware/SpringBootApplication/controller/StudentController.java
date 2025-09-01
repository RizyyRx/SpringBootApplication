package com.hexaware.SpringBootApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.SpringBootApplication.entity.Student;
import com.hexaware.SpringBootApplication.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// Communication between http request and response - client (POSTMAN app)
	@PostMapping
	 public ResponseEntity<Student> CreateUser(@RequestBody Student stud)
	    {
		    Student savedStudent=studentService.createUser(stud);
	        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	    
	    }

	
}
