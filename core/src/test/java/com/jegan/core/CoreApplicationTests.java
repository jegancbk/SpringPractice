package com.jegan.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jegan.core.service.PaymentService;
import com.jegan.core.service.PaymentServiceImpl;

import static org.junit.Assert.*;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	PaymentServiceImpl service;
	@Test
	void testDependencyInjection() {
		assertNotNull(service.getDao());
	}

}
