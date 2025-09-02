package com.hexaware.SpringBootApplication.entity;

import jakarta.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String studentName;
	
	@Column(nullable = true)
	private int studentAge;
	
	//Autowired
	@ManyToOne
	@JoinColumn(name = "deptId")
	private Department dept;
	
	public Student(int id, String studentName, int studentAge, Department dept) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.dept = dept;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", studentAge=" + studentAge + ", dept=" + dept
				+ "]";
	}


	

}
