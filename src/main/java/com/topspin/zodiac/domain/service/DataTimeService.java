package com.topspin.zodiac.domain.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DataTimeService {
	
	public LocalDate valueOf(String birthday) {
		
		DateTimeFormatter monthYearFmt = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		return LocalDate.parse(birthday, monthYearFmt);
	}
}