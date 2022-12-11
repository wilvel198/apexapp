package com.apex.controllers;

import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.apex.models.ResponseValue;
import com.apex.models.TransactionInfo;
import discountlogic.ApexPointLogic;

@RestController
public class DiscountControllers {
	private static final Logger LOGGER = LogManager.getLogger(DiscountControllers.class);

	@GetMapping(path = "/status", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseValue status() {
		LOGGER.debug("holder for debug status call");
		ApexPointLogic serviceStatusInfo = new ApexPointLogic();
		ResponseValue serviceCheck = serviceStatusInfo.getServiceStatus();
		return serviceCheck;
		
	}
	
	
	@PostMapping(value = "/calculatedpoints",  consumes = "application/json", produces = "application/json")
	public ResponseValue transactionInfo(@RequestBody TransactionInfo transactionInfo, HttpServletResponse response) {
		LOGGER.debug("holder for debug calculate points");
		int spentValue = transactionInfo.getDollarSpent();
		
		LOGGER.debug("value to be processed " + transactionInfo.getDollarSpent());
		
		ApexPointLogic calculatedDiscount = new ApexPointLogic();
		ResponseValue calculatedPoints = calculatedDiscount.calculateDiscount(spentValue);
		
		return calculatedPoints;
	}
}
