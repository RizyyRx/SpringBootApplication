package com.hexaware.SpringBootApplication.service;

import java.util.List;

import com.hexaware.SpringBootApplication.entity.Department;
import com.hexaware.SpringBootApplication.entity.Student;

public interface DepartmentService {

	Department createDepartment(Department dept);
	
	List<Department> getAllDepartments();
	
	Department getDepartmentById(int deptId);
	
	void deleteDepartmentById(int deptId);
	
	Department updateDepartmentById(int deptId, Department dept);
}
