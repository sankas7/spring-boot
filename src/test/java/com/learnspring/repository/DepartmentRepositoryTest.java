package com.learnspring.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import com.learnspring.Spring3LearnDemoApplication;
import com.learnspring.entity.Department;

@DataJpaTest
@ContextConfiguration(classes = Spring3LearnDemoApplication.class)
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
    private TestEntityManager entityManager;
    
	
	@BeforeEach
	public void setUp()
	{
		
		Department setDepartment=new Department();
		setDepartment.setDepartmentName("IT");
		setDepartment.setDepartmentCode("D1");
		setDepartment.setDepartmentAddress("Kolkata");
		entityManager.persist(setDepartment);
		
	}
	
	
	@Test
	public void testSuccessFindDepartmentById()
	{
		
		Department department=departmentRepository.findById(1L).get();
		
		assertEquals("IT", department.getDepartmentName());
	}
    

	
}
