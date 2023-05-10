package com.learnspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.learnspring.entity.Department;
import com.learnspring.entity.DepartmentUpdateRequest;

@Mapper
public interface DepartmentMapper {

	 @Mapping(target = "departmentId", ignore = true)
	// @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	 void departmentRequestToDepartment(DepartmentUpdateRequest departmentUpdateRequest, @MappingTarget Department department);
}
