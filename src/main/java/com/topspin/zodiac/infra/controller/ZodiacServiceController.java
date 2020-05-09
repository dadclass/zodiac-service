package com.topspin.zodiac.infra.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topspin.zodiac.domain.service.ZodiacService;
import com.topspin.zodiac.domain.vo.BirthdayVO;
import com.topspin.zodiac.infra.service.DataTransformService;

@RestController
public class ZodiacServiceController {
	
	@Autowired
	private ZodiacService zSvc;
	
	@Autowired
	private DataTransformService dataTranSvc;
	
	// request sample: http://localhost:8080/zodiac?json=%7B%22day%22%3A%2201%22%2C%22month%22%3A%2207%22%2C%22year%22%3A%221997%22%7D
    @RequestMapping("/zodiac")
    public String getZodiacAnimal(@RequestParam(name="json") String encodedJson)
    		throws UnsupportedEncodingException {
    	
    	BirthdayVO vo = dataTranSvc.toBirthdayVO(encodedJson);
        return zSvc.getZodiacAnimal(vo.toLocalDate());
    }
}
