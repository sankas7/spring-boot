package com.learnspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.learnspring.entity.Department;
import com.learnspring.entity.DepartmentUpdateRequest;

@Mapper
public interface DepartmentMapper {
	
	 // @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	 @Mapping(target = "departmentId", ignore = true)
	 void departmentRequestToDepartment(DepartmentUpdateRequest departmentUpdateRequest, @MappingTarget Department department);
}
