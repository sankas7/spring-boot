package com.concept.component.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentBaseClass {

	@Autowired
	private ComponentInnerClass inClass;

	public ComponentInnerClass getInClass() {
		return inClass;
	}
	
	
}
