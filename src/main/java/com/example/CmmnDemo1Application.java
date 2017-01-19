package com.example;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.spring.boot.starter.SpringBootProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableScheduling
@ProcessApplication
public class CmmnDemo1Application extends SpringBootProcessApplication {

	private static int PORT;
	private static final Logger LOGGER = LoggerFactory.getLogger(CmmnDemo1Application.class);
	
	@Autowired
	private CaseService caseService;

	public static void main(String[] args) {
		SpringApplication.run(CmmnDemo1Application.class, args);
		LOGGER.info("You can reach the web app under: http://localhost:{}/", PORT);
	}

	@Component
	public static class ServletContainerListener
			implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

		@Override
		public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
			PORT = event.getEmbeddedServletContainer().getPort();
		}

	}
	
	@Component
	public class ApplicationStartup 
	implements ApplicationListener<ApplicationReadyEvent> {
		@Override
		  public void onApplicationEvent(final ApplicationReadyEvent event) {
			caseService.createCaseInstanceByKey("loan_application",
			        Variables.createVariables()
			          .putValue("applicationSufficient", Variables.booleanValue(null))
			          .putValue("rating", Variables.integerValue(null)));
			LOGGER.info("Process registered");
		  }
	}

}
