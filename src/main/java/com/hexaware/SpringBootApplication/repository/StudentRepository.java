package com.hexaware.SpringBootApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.SpringBootApplication.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
