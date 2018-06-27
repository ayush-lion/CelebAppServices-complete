package com.ctn.celebApp.service;

import java.util.List;

import com.ctn.celebApp.celebrequest.CelebCreateRequest;
import com.ctn.celebApp.celebrequest.EmployeSubmitRequest;
import com.ctn.celebApp.celebresponse.CelebDetailsResponse;
import com.ctn.celebApp.entity.Employe;
import com.ctn.celebApp.userresponse.EmployeSubmitResponse;

public interface CelebService {

	public CelebDetailsResponse create(CelebCreateRequest celebCreateRequest);

	public EmployeSubmitResponse submit(EmployeSubmitRequest celebCreateRequest)throws Exception;

	public List<Employe> employe();

}
