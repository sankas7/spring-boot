package com.learnspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUpdateRequest {

	
	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
