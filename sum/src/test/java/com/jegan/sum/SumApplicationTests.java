package com.jegan.sum;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class SumApplicationTests {

	@Autowired
	GiveSum sum;
	
	@Test
	void testRetSum() {
		assertEquals(5, sum.retSum(2, 3));
	}

}
