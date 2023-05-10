package com.learnspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnspring.entity.Department;
import com.learnspring.entity.DepartmentUpdateRequest;
import com.learnspring.exception.DepartmentException;
import com.learnspring.mapper.DepartmentMapper;
import com.learnspring.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}


	@Override
	public List<Department> fetchAllDepartments() {
		return departmentRepository.findAll();
	}


	@Override
	public Department findDepartmentById(Long departmentId) throws DepartmentException {
		
		return departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentException("Department not found with id - "+ departmentId));
	}


	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}


	@Override
	public Department updateDepartment(Long departmentId, DepartmentUpdateRequest departmentUpdateRequest) throws DepartmentException {
		
		
		Department department =departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentException("Department not found with id - "+ departmentId));
		
	     departmentMapper.departmentRequestToDepartment(departmentUpdateRequest, department);
	     
	     return departmentRepository.save(department);
		
		
	}


	@Override
	public Department findDepartmentByName(String departmentName) {
		
		return departmentRepository.findByDepartmentName(departmentName);
	}

}
