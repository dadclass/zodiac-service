package com.topspin.zodiac.domain.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BirthdayVO {
	private String day;
	private String month;
	private String year;

	public BirthdayVO(String day, String month, String year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getYear() {
		return year;
	}
	
	public LocalDate toLocalDate() {
		DateTimeFormatter birthdayFmt = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		return LocalDate.parse(
				String.format("%s/%s/%s", this.getDay(), this.getMonth(), this.getYear()),
				birthdayFmt);
	}
}
