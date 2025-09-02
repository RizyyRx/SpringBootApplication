package com.hexaware.SpringBootApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.SpringBootApplication.entity.Department;
import com.hexaware.SpringBootApplication.entity.Student;
import com.hexaware.SpringBootApplication.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

	private DepartmentRepository departmentRepo;

	public DepartmentServiceImplementation(DepartmentRepository departmentRepo) {
		super();
		this.departmentRepo = departmentRepo;
	}

	@Override
	public Department createDepartment(Department dept) {
		// TODO Auto-generated method stub
		return departmentRepo.save(dept);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		Optional<Department> deptById = departmentRepo.findById(deptId);
		return deptById.get();
	}

	@Override
	public void deleteDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		departmentRepo.deleteById(deptId);
	}

	@Override
	public Department updateDepartmentById(int deptId, Department dept) {
		// TODO Auto-generated method stub
			Optional<Department> oldDepartmentOptional = departmentRepo.findById(deptId);
			
			if(oldDepartmentOptional.isPresent()) {
				Department oldDepartment = oldDepartmentOptional.get();
				
				oldDepartment.setDeptName(dept.getDeptName());
				
				return departmentRepo.save(oldDepartment);
			}else {
				throw new RuntimeException("Department with id: "+deptId+" is not found");
			}
	}
	
}
