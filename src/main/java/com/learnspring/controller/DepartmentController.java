package com.learnspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.entity.Department;
import com.learnspring.entity.DepartmentUpdateRequest;
import com.learnspring.exception.DepartmentException;
import com.learnspring.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchAllDepartments()
	{
		return departmentService.fetchAllDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public Department findDepartmentById(@PathVariable("id")Long departmentId) throws DepartmentException
	{
		return departmentService.findDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id")Long departmentId)
	{
		
		departmentService.deleteDepartmentById(departmentId);
		return "Department" + departmentId+ " is deleted successfully";
		
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id")Long departmentId,@RequestBody DepartmentUpdateRequest departmentUpdateRequest) throws DepartmentException
	
	{
		return departmentService.updateDepartment(departmentId,departmentUpdateRequest);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department findDepartmentByName(@PathVariable("name")String departmentName)
	{
		return departmentService.findDepartmentByName(departmentName);
	}
	
	
}
