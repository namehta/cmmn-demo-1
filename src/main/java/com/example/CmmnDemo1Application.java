package com.example;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.spring.boot.starter.SpringBootProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ProcessApplication
public class CmmnDemo1Application extends SpringBootProcessApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CmmnDemo1Application.class);
	
	@Autowired
	private CaseService caseService;

	public static void main(String[] args) {
		SpringApplication.run(CmmnDemo1Application.class, args);
		LOGGER.info("*** Application deployed ***");
	}	
	
}
