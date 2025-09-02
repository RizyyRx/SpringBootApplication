package com.hexaware.SpringBootApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.SpringBootApplication.entity.Student;
import com.hexaware.SpringBootApplication.service.DepartmentService;
import com.hexaware.SpringBootApplication.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
	
	private StudentService studentService;
	
	private DepartmentService departmentService;

	public StudentController(StudentService studentService, DepartmentService departmentService) {
		super();
		this.studentService = studentService;
		this.departmentService = departmentService;
	}


	
	// Communication between http request and response - client (POSTMAN app)
	@PostMapping
	 public ResponseEntity<Student> CreateUser(@RequestBody Student stud)
	    {
		    Student savedStudent=studentService.createUser(stud);
	        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	    
	    }
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> getStudent = studentService.getAllStudents();
		return new ResponseEntity<>(getStudent,HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int studId){
		Student getStudentById = studentService.getStudentById(studId);
		return new ResponseEntity<>(getStudentById,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int studId){
		studentService.deleteStudentById(studId);
		return new ResponseEntity<>("record deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	 public ResponseEntity<Student> updateUser(@PathVariable("id") int studId,@RequestBody Student stud)
	    {
		    Student updatedStudent=studentService.updateStudentById(studId, stud);
	        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	    }
}
