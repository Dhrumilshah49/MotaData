package com.example.MotaData;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class MotaDataApplication {

	private static final Logger log = LogManager.getLogger(MotaDataApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MotaDataApplication.class, args);

		log.info("Demo Starts");
	}


}
