package com.jegan.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringjmsApplicationTests {

	@Autowired
	MessageSender sender;
	@Test
	void testSendAndRecieve() {
		sender.send("Hello Spring JMS!!");
	}

}
