package com.jegan.springweb.healthchecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		
		boolean error = System.currentTimeMillis() % 2 == 0;
		
		if (error) {
			return Health.down().withDetail("errorCode", "123").build();
		}
		
		return Health.up().build();
	}

}
