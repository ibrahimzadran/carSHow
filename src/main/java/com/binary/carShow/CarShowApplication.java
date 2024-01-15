package com.binary.carShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



//@EnableAutoConfiguration  // this enables SB automatic configration. spring boot will auto,automatically configure project based on the dependencies
// for example,
//@ComponentScan // this enables the SB component scan to find all of the component in app
//@Configuration // this c=annotation is used to define a configuration class that provides beans to the spring application..
@SpringBootApplication
public class CarShowApplication {
private static final Logger logger = LoggerFactory.getLogger(CarShowApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);

		logger.info("Application started ");

	}

}
