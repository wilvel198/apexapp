package com.apex.controllers;

import java.net.http.HttpResponse.ResponseInfo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apex.models.ResponseValue;
import com.apex.models.TransactionInfo;

import discountlogic.ApexDiscountLogic;

@RestController
public class DiscountControllers {


	@GetMapping(path = "/status", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseValue status() {
		
		ApexDiscountLogic serviceStatusInfo = new ApexDiscountLogic();
		ResponseValue serviceCheck = serviceStatusInfo.getServiceStatus();
		return serviceCheck;
		
	}
	
	
	@PostMapping(value = "/calculatedpoints",  consumes = "application/json", produces = "application/json")
	public ResponseValue transactionInfo(@RequestBody TransactionInfo transactionInfo, HttpServletResponse response) {
		int spentValue = transactionInfo.getDollarSpent();
		
		System.out.println("value to be processed " + transactionInfo.getDollarSpent());
		
		ApexDiscountLogic calculatedDiscount = new ApexDiscountLogic();
		
		ResponseValue calculatedPoints = calculatedDiscount.calculateDiscount(spentValue);
		
		return calculatedPoints;
	}
}
