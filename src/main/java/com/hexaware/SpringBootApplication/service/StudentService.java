package com.hexaware.SpringBootApplication.service;

import java.util.List;

import com.hexaware.SpringBootApplication.entity.Student;

public interface StudentService {

	Student createUser(Student stud);
	
	List<Student> getAllStudents();
	
	Student getStudentById(int studId);
	
	void deleteStudentById(int studId);
	
	Student updateStudentById(int studId, Student stud);
	
}
