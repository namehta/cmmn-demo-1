package com.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApprovalDelegate implements JavaDelegate {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(DelegateExecution caseExecution) throws Exception {
		logger.info("Plan Item '" + caseExecution.getCurrentActivityId() + "' labeled '"
		        + caseExecution.getCurrentActivityName() + "' has performed transition: "
		        + caseExecution.getEventName());

	}

}
