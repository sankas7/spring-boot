package com.learnspring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.learnspring.Spring3LearnDemoApplication;
import com.learnspring.entity.Department;
import com.learnspring.repository.DepartmentRepository;

@SpringBootTest
@ContextConfiguration(classes = Spring3LearnDemoApplication.class)
public class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private  DepartmentRepository departmentRepository;
	
	@BeforeEach
	public void setUp()
	{
		
		Department setDepartment=new Department(1L, "IT", "Kolkata","D1");
		
		Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(setDepartment);
		
	}
	
	@Test
	@DisplayName("Testing getting department by name")
	public void testGetDepartmentByNameSuccess()
	{
		
		Department department = departmentService.findDepartmentByName("IT");
		
		assertEquals("IT", department.getDepartmentName());
	}
	
	
}
