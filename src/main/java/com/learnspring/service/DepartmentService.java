package com.learnspring.service;

import java.util.List;

import com.learnspring.entity.Department;
import com.learnspring.entity.DepartmentUpdateRequest;
import com.learnspring.exception.DepartmentException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> fetchAllDepartments();

	Department findDepartmentById(Long departmentId) throws DepartmentException;

	void deleteDepartmentById(Long departmentId);

	Department updateDepartment(Long departmentId, DepartmentUpdateRequest departmentUpdateRequest) throws DepartmentException;

	Department findDepartmentByName(String departmentName);

}
