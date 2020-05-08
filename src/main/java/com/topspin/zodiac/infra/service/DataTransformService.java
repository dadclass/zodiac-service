package com.topspin.zodiac.infra.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.topspin.zodiac.domain.vo.BirthdayVO;

@Service
public class DataTransformService {
	
	public LocalDate toBirthday(String encodedJson) throws UnsupportedEncodingException {
		
		Gson gson = new Gson();
		String decodedJson = URLDecoder.decode(encodedJson, StandardCharsets.UTF_8.toString());
		
		BirthdayVO birthday = gson.fromJson(decodedJson, BirthdayVO.class);
		return birthday.toLocalDate();
	}
}
