package com.example;

import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.runtime.CaseInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseControlServices {
	
	@Autowired
	private CaseService caseService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CaseControlServices.class);

    @RequestMapping("/case/create")
    public String createCase() {
    	CaseInstance caseInstance = caseService.createCaseInstanceByKey("loan_application",
		        Variables.createVariables()
		          .putValue("applicationSufficient", Variables.booleanValue(null))
		          .putValue("rating", Variables.integerValue(null)));
		LOGGER.info("Case instance " + caseInstance.getCaseInstanceId() + " created");
        return "Case Instance " + caseInstance.getCaseInstanceId() + " created";
    }
}
