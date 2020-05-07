package com.topspin.zodiac.infra.service;

import org.springframework.stereotype.Service;

@Service
public class DataTransformService {
	
	public String toBirthday(String birthMonth) {
		return "01/" + birthMonth;
	}
}
