package com.oa.pma.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufactureConfig {
	
	@Bean
	public Car newCar() {
		Engine d = new Engine();
		Door   e = new Door();
		Wheel  w = new Wheel();
		return new Car(d, e, w);
	}
}
