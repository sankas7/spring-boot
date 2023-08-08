package com.learnspring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnspring.Spring3LearnDemoApplication;
import com.learnspring.entity.Department;
import com.learnspring.repository.DepartmentRepository;

@SpringBootTest
@ContextConfiguration(classes = Spring3LearnDemoApplication.class)
@AutoConfigureMockMvc
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void testDepartmentSaveSuccess() throws JsonProcessingException, Exception {

		Department department = new Department(2l, "Sales", "kolkata", "D2");

		mockMvc.perform(post("/departments").contentType("application/json")
				.content(objectMapper.writeValueAsString(department))).andExpect(status().isOk());
		
		
		Department departmentByName=departmentRepository.findByDepartmentName("Sales");
		
		assertEquals("kolkata",departmentByName.getDepartmentAddress());
		
		
		

	}

}
