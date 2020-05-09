package com.topspin.zodiac.infra.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.topspin.zodiac.domain.vo.BirthdayVO;

@Service
public class DataTransformService {
	
	public BirthdayVO toBirthdayVO(String encodedJson) throws UnsupportedEncodingException {
		Gson gson = new Gson();
		String decodedJson = URLDecoder.decode(encodedJson, StandardCharsets.UTF_8.toString());
		
		return gson.fromJson(decodedJson, BirthdayVO.class);
	}
}
