package com.hexaware.SpringBootApplication.service;

import org.springframework.stereotype.Service;

import com.hexaware.SpringBootApplication.entity.Student;
import com.hexaware.SpringBootApplication.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {

	private StudentRepository studentRepo;
	
	public StudentServiceImplementation(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public Student createUser(Student stud) {
		// TODO Auto-generated method stub
		return studentRepo.save(stud);
	}
}
