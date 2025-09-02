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

import com.hexaware.SpringBootApplication.entity.Department;
import com.hexaware.SpringBootApplication.entity.Student;
import com.hexaware.SpringBootApplication.service.DepartmentService;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@PostMapping
	 public ResponseEntity<Department> CreateDepartment(@RequestBody Department dept)
	    {
		    Department savedDepartment=departmentService.createDepartment(dept);
	        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	    
	    }
	
	@GetMapping
	public ResponseEntity<List<Department>> getDepartments(){
		List<Department> departments = departmentService.getAllDepartments();
		return new ResponseEntity<>(departments,HttpStatus.OK); 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int deptId){
		Department department = departmentService.getDepartmentById(deptId);
		return new ResponseEntity<>(department,HttpStatus.OK); 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") int deptId){
		departmentService.deleteDepartmentById(deptId);
		return new ResponseEntity<>("Successfully deleted department with id: "+deptId, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	 public ResponseEntity<Department> updateUser(@PathVariable("id") int deptId,@RequestBody Department dept)
	    {
		    Department updatedDepartment=departmentService.updateDepartmentById(deptId, dept);
	        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	    }
}
