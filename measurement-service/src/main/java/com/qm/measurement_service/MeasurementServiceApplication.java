package com.qm.measurement_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qm")
public class MeasurementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeasurementServiceApplication.class, args);
	}
}