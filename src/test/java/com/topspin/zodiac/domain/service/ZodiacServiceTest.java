package com.topspin.zodiac.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.topspin.zodiac.domain.vo.BirthdayVO;

@SpringBootTest
@DisplayName("Test zodiac sign and Chinese zodiac service")
class ZodiacServiceTest {
	private BirthdayVO vo = null;
	
	@Autowired
	ZodiacService svc;
	
	@BeforeEach
	void initBirthdayVO() {
		vo = new BirthdayVO("14", "07", "1979");
	}

	@Test
	@DisplayName("Verify July 14 is Cancer")
	void testGetZodiacSign() {
		assertEquals("Cancer", svc.getZodiacSign(vo));
	}
	
	@Test
	@DisplayName("Verify 1979 is Goat")
	void testGetChineseZodiac() {
		assertEquals("Goat", svc.getChineseZodiac(vo));
	}
}
