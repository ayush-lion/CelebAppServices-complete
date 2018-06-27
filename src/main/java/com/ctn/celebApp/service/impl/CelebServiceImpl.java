package com.ctn.celebApp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctn.celebApp.celebrequest.CelebCreateRequest;
import com.ctn.celebApp.celebrequest.EmployeSubmitRequest;
import com.ctn.celebApp.celebresponse.CelebDetailsResponse;
import com.ctn.celebApp.dao.CelebRepository;
import com.ctn.celebApp.dao.EmployeRepository;
import com.ctn.celebApp.entity.CelebDetails;
import com.ctn.celebApp.entity.Employe;
import com.ctn.celebApp.enums.Status;
import com.ctn.celebApp.service.CelebService;
import com.ctn.celebApp.userresponse.EmployeSubmitResponse;

@Service
public class CelebServiceImpl implements CelebService {

	@Autowired
	CelebRepository celebRepository;

	@Autowired
	EmployeRepository employeRepo;

	@Override
	public CelebDetailsResponse create(CelebCreateRequest celebCreateRequest) {
		CelebDetailsResponse celebDetailsRespons = new CelebDetailsResponse();
		final CelebDetails celebDetails = celebRepository.findByEmail(celebCreateRequest.getEmail());

		if (celebDetails != null) {
			celebDetailsRespons.setStatus(Status.FAILED);
			celebDetailsRespons.setMessage("Celeb already exist");
			return celebDetailsRespons;
		} else {
			final CelebDetails celebDetail = new CelebDetails();
			celebDetail.setCelebname(celebCreateRequest.getCelebname());
			celebDetail.setEmail(celebCreateRequest.getEmail());
			celebDetail.setHeight(celebCreateRequest.getHeight());
			celebDetail.setProfile(celebCreateRequest.getProfile());
			celebDetail.setOccupation(celebCreateRequest.getOccupation());
			celebDetail.setDob(celebCreateRequest.getDob());
			celebDetail.setAge(celebCreateRequest.getAge());
			celebDetail.setWicket(celebCreateRequest.getWicket());
			celebDetail.setRun(celebCreateRequest.getRun());
			celebDetail.setPlayingrole(celebCreateRequest.getPlayingrole());
			celebDetail.setBattingstyle(celebCreateRequest.getBattingstyle());
			celebDetail.setBowlingstyle(celebCreateRequest.getBowlingstyle());
			celebDetail.setMajorteams(celebCreateRequest.getMajorteams());
			celebDetail.setMatchplayed(celebCreateRequest.getMatchplayed());
			celebDetail.setDate(celebCreateRequest.getDate());

			celebRepository.save(celebDetail);

			celebDetailsRespons.setStatus(Status.SUCCESS);
			celebDetailsRespons.setMessage("All Details saved Successfully");
			return celebDetailsRespons;
		}
	}

	@Override
	public EmployeSubmitResponse submit(EmployeSubmitRequest employeSubmitRequest) throws Exception {
		EmployeSubmitResponse employeSubmitResponse=new EmployeSubmitResponse();
		Employe emp = employeRepo.getLastData(employeSubmitRequest.getEmpname());
		if (emp == null) {
			
			Employe employe = new Employe();
			employe.setEmpname(employeSubmitRequest.getEmpname());
			employe.setDayformatted(employeSubmitRequest.getDayformatted());
			employe.setChekin(employeSubmitRequest.getChekin());
			employeRepo.save(employe);
		} else {
			if (emp.getChekout() == null) {
				emp.setChekout(employeSubmitRequest.getChekout());
				SimpleDateFormat format = new SimpleDateFormat("hh.mm.ss");
				Date date1 = format.parse(emp.getChekin());
				Date date2 = format.parse(employeSubmitRequest.getChekout());
				Integer difference = (int) (date2.getTime() - date1.getTime());				
				
				String differenceSeconds =String.valueOf(difference / 1000 % 60);
			    String differenceMinutes =String.valueOf(difference / (60 * 1000) % 60);
			    String differenceHours =String.valueOf(difference / (60 * 60 * 1000) % 24);
				emp.setDuration(differenceHours+":"+differenceMinutes+":"+differenceSeconds);
				
				employeRepo.save(emp);
				
			} else {
				
				Employe employe = new Employe();
				employe.setEmpname(employeSubmitRequest.getEmpname());
				employe.setDayformatted(employeSubmitRequest.getDayformatted());
				employe.setChekin(employeSubmitRequest.getChekin());
				employeRepo.save(employe);
			}
		}
		employeSubmitResponse.setStatus(Status.SUCCESS);
		return employeSubmitResponse;
	}

	@Override
	public List<Employe> employe() {
	return (List<Employe>) employeRepo.findAll();
	}
}
