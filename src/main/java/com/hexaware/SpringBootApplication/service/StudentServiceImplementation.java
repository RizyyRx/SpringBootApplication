package com.hexaware.SpringBootApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.SpringBootApplication.entity.Student;
import com.hexaware.SpringBootApplication.repository.DepartmentRepository;
import com.hexaware.SpringBootApplication.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {

	private StudentRepository studentRepo;
	
	private DepartmentRepository departmentRepo;
	
	public StudentServiceImplementation(StudentRepository studentRepo, DepartmentRepository departmentRepo) {
		super();
		this.studentRepo = studentRepo;
		this.departmentRepo = departmentRepo;
	}

	@Override
	public Student createUser(Student stud) {
		// TODO Auto-generated method stub
		return studentRepo.save(stud);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub

		return studentRepo.findAll();
	}

	// To get a information from the table by using the id, we need 2 methods. One is findById() and another is get() 
	@Override
	public Student getStudentById(int studId) {
		// TODO Auto-generated method stub
		Optional<Student> studentId = studentRepo.findById(studId);
		return studentId.get();
	}

	@Override
	public void deleteStudentById(int studId) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(studId);
	}

	@Override
	public Student updateStudentById(int studId, Student stud) {
		// TODO Auto-generated method stub
		Optional<Student> oldStudentOptional = studentRepo.findById(studId);
		
		if(oldStudentOptional.isPresent()) {
			Student oldStudent = oldStudentOptional.get();
			
			oldStudent.setStudentName(stud.getStudentName());
			oldStudent.setStudentAge(stud.getStudentAge());
			oldStudent.setDept(stud.getDept());
			
			return studentRepo.save(oldStudent);
		}else {
			throw new RuntimeException("Student with id: "+studId+" is not found");
		}
	}
}
