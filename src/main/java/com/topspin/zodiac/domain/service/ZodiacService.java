package com.topspin.zodiac.domain.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.topspin.zodiac.domain.vo.BirthdayVO;

@Service
public class ZodiacService {
	private static final Logger LOGGER=LoggerFactory.getLogger(ZodiacService.class);
	
	public String getZodiacAnimal(BirthdayVO vo) {
		
		String zodiacSign = getZodiacSign(vo);
		String chineseZodiac = getChineseZodiac(vo);
		
		return String.format("You're a %s %s", zodiacSign, chineseZodiac);
	}
	
	protected String getZodiacSign(BirthdayVO vo) {
		LocalDate birthday = vo.toLocalDate();
        int day = birthday.getDayOfMonth();
        int month = birthday.getMonthValue();
        
        return findZodiacByDate(day, month);
//        return findZodiacByCode(day, month);
	}

	protected String findZodiacByDate(int day, int month) {
        if (month == 12 && day >= 22 || month == 1 && day < 20) {
            return "Capricorn";
        } else if (month == 1 && day >= 20 || month == 2 && day < 19) {
            return "Aquarius";
        } else if (month == 2 && day >= 19 || month == 3 && day < 21) {
            return "Pisces";
        } else if (month == 3 && day >= 21 || month == 4 && day < 20) {
            return "Aries";
        } else if (month == 4 && day >= 20 || month == 5 && day < 21) {
            return "Taurus";
        } else if (month == 5 && day >= 21 || month == 6 && day < 21) {
            return "Gemini";
        } else if (month == 6 && day >= 21 || month == 7 && day < 23) {
            return "Cancer";
        } else if (month == 7 && day >= 23 || month == 8 && day < 23) {
            return "Leo";
        } else if (month == 8 && day >= 23 || month == 9 && day < 23) {
            return "Virgo";
        } else if (month == 9 && day >= 23 || month == 10 && day < 23) {
            return "Libra";
        } else if (month == 10 && day >= 23 || month == 11 && day < 22) {
            return "Scorpio";
        } else if (month == 11 && day >= 22 || month == 12 && day < 22) {
            return "Sagittarius";
        }
        return "";
	}

	/*
	protected String findZodiacByCode(int day, int month) {
		int zodiacCode = (month *100) + day;
		
		if (zodiacCode < 119) return "Capricorn";
		if (zodiacCode >= 120 && zodiacCode < 219) return "Aquarius";
		if (zodiacCode >= 219 && zodiacCode < 321) return "Pisces";
		if (zodiacCode >= 321 && zodiacCode < 420) return "Aries";
		if (zodiacCode >= 420 && zodiacCode < 521) return "Taurus";
		if (zodiacCode >= 521 && zodiacCode < 621) return "Gemini";
		if (zodiacCode >= 621 && zodiacCode < 723) return "Cancer";
		if (zodiacCode >= 723 && zodiacCode < 823) return "Leo";
		if (zodiacCode >= 823 && zodiacCode < 923) return "Virgo";
		if (zodiacCode >= 923 && zodiacCode < 1023) return "Libra";
		if (zodiacCode >= 1023 && zodiacCode < 1122) return "Scorpio";
		if (zodiacCode >= 1122 && zodiacCode < 1222) return "Sagittarius";
		if (zodiacCode > 1222) return "Capricorn";
		return String.format("No zodiac code for %s", zodiacCode);
	}
	*/

	protected String getChineseZodiac(BirthdayVO vo) {
		LocalDate birthday = vo.toLocalDate();
        int year = birthday.getYear();
        return findChineseZodiacBySwitch(year);
//        return findChineseZodiacByArray(year);
    }

	protected String findChineseZodiacBySwitch(int year) {
        switch (year % 12) {
        case 0:
            return "Monkey";
        case 1:
            return "Rooster";
        case 2:
            return "Dog";
        case 3:
            return "Pig";
        case 4:
            return "Rat";
        case 5:
            return "Ox";
        case 6:
            return "Tiger";
        case 7:
            return "Rabbit";
        case 8:
            return "Dragon";
        case 9:
            return "Snake";
        case 10:
            return "Horse";
        case 11:
            return "Goat";
        }
        return "";    	
    }

	/*
	protected String findChineseZodiacByArray(int year) {
    	String[] chineseZodiac = {
    		"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox",
    		"Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat"
    	};
    	return chineseZodiac[year % 12];
	}
	*/
}
