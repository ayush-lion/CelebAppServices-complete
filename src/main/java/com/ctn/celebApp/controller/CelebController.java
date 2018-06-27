package com.ctn.celebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctn.celebApp.celebrequest.CelebCreateRequest;
import com.ctn.celebApp.celebrequest.EmployeSubmitRequest;
import com.ctn.celebApp.celebresponse.CelebDetailsResponse;
import com.ctn.celebApp.entity.Employe;
import com.ctn.celebApp.service.CelebService;
import com.ctn.celebApp.userresponse.EmployeSubmitResponse;

@RestController
@CrossOrigin
@RequestMapping("/celeb")
public class CelebController {
		
	@Autowired
	CelebService celebService;

	@RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.POST)
	public CelebDetailsResponse celebCreation(@RequestBody CelebCreateRequest celebCreateRequest) {
		
	return celebService.create(celebCreateRequest);
	}
	
	@RequestMapping(value = "/submit", produces = "application/json", method = RequestMethod.POST)
	public EmployeSubmitResponse celebCreation(@RequestBody EmployeSubmitRequest employeSubmitRequest) throws Exception  {
		
	return celebService.submit(employeSubmitRequest);
	}
	
	@RequestMapping(value = "/get", produces = "application/json", method = RequestMethod.GET)
	public List<Employe> employe(){
			
	return celebService.employe();
	}
}
