package com.topspin.zodiac.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topspin.zodiac.domain.service.ZodiacService;
import com.topspin.zodiac.infra.service.DataTransformService;

@RestController
public class ZodiacServiceController {
	
	@Autowired
	private ZodiacService zSvc;
	
	@Autowired
	private DataTransformService dataTranSvc;
	
    @RequestMapping("/zmascot")
    public String getZodiacMascot(@RequestParam(name="birthmonth") String birthMonth) {
        return zSvc.getZodiacMascot(dataTranSvc.toBirthday(birthMonth));
    }
}
