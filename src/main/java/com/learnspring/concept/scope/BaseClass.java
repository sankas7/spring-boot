package com.learnspring.concept.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BaseClass {

	private static final Logger LOGGER=LoggerFactory.getLogger(BaseClass.class);
	@Autowired
	private InnerClass inClass;

	@Value("${url.load}")
	private String urlToLoad;
	
	
	public String getUrlToLoad() {
		return urlToLoad;
	}

	public InnerClass getInClass() {
		return inClass;
	}
	
	@PostConstruct
	public void intialize()
	{
		LOGGER.info("Bean is intialized");
	}
	
	@PreDestroy
	public void gettingDestroyed()
	{
		LOGGER.info("Bean is getting destroyed");
	}
	
}
