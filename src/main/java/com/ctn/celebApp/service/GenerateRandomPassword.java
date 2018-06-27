package com.ctn.celebApp.service;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GenerateRandomPassword {

	@Async
	public String RandomPassword()
	{
		String numbers = "123456789";
		String upperAlpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlpha=upperAlpha.toLowerCase();
		String specialChar="@#$%&";
		String finalString=numbers+upperAlpha+lowerAlpha+specialChar;

		Random rndm_method = new Random();
		
		int len=8;
		String randomPassword="";
		
		for (int i = 0; i < len; i++)
		{
			randomPassword = randomPassword+finalString.charAt(rndm_method.nextInt(finalString.length()));
		}
		return randomPassword;
	}
}
