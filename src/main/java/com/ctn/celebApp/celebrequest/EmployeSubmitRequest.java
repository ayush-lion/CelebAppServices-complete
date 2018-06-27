package com.ctn.celebApp.celebrequest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class EmployeSubmitRequest {
	
	 String empname;
	
	 String day;
	
	 String dayformatted;
	
	 String chekin;
	 
	 String chekout;

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getChekin() {
		SimpleDateFormat formatter = new SimpleDateFormat("hh.mm.ss");  
		Date date = new Date();  
		this.chekin = (formatter.format(date));  
		return chekin;
	}

	public String getChekout() {
		SimpleDateFormat formatter = new SimpleDateFormat("hh.mm.ss");  
		Date date = new Date();  
		this.chekout = (formatter.format(date));  
		return chekout;
	}
	
	/*public String getMonth() {
		  Calendar cal = Calendar.getInstance();
		  	String[] monthName = { "January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December" };
		  	this.month = monthName[cal.get(Calendar.MONTH)];
		return month;
	}*/

	public String getDayformatted() {
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		this.dayformatted = todayKolkata.toString();
		return dayformatted;
	}
}
