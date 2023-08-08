package com.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.concept.component.scan.ComponentBaseClass;
import com.learnspring.concept.scope.BaseClass;

@SpringBootApplication
@ComponentScan({"com.concept.component.scan","com.learnspring"})
@PropertySource("classpath:test.properties")
public class SpringConcepts {

	private static final Logger LOGGER=LoggerFactory.getLogger(SpringConcepts.class);
	
	public static void main(String args[])
	{
		ApplicationContext context=SpringApplication.run(SpringConcepts.class, args);
		
		for(String bean:context.getBeanDefinitionNames())
		{
		LOGGER.info("Bean names - {} " , bean);
		}
	    BaseClass bClass=context.getBean(BaseClass.class);
	    BaseClass bClass1=context.getBean(BaseClass.class);
	    
	    System.out.println(bClass);
	    System.out.println(bClass.getInClass());
	    
	    System.out.println("Prop value - "+bClass.getUrlToLoad());
	    
	    System.out.println(bClass1);
	    System.out.println(bClass1.getInClass());
	    
	    ComponentBaseClass componentClass=context.getBean(ComponentBaseClass.class);
	    System.out.println(componentClass);
	    
	    
	    
	    
	}
}
