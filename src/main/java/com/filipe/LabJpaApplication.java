package com.filipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.filipe.service.PointService;

@SpringBootApplication
public class LabJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LabJpaApplication.class, args);
	}
	
	@Autowired
	private PointService pointService;

	@Override
	public void run(String... args) throws Exception {
		pointService.inserirDez();
		
	}

}
