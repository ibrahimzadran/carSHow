package com.binary.carShow;
import com.binary.carShow.entity.Car;
import com.binary.carShow.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@EnableAutoConfiguration  // this enables SB automatic configration. spring boot will auto,automatically configure project based on the dependencies
// for example,
//@ComponentScan // this enables the SB component scan to find all of the component in app
//@Configuration // this c=annotation is used to define a configuration class that provides beans to the spring application..
@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {
	@Autowired
	private CarRepository carRepository;
private static final Logger logger = LoggerFactory.getLogger(CarShowApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);

		logger.info("Application started ");

	}

	@Override
	public void run(String... args) throws Exception {

		List<Car> cars = Arrays.asList(
				new Car("Ford","Lighting","Gray","FL-234",2023,75000),
				new Car("Nissan","Leaf","Green","BFG-345",2022,40000),
				new Car("Toyota","Sienna","Silver","CDF-233",2024,60000),
				new Car("Honda","Accord","White","HW-345",2024,57000)
		);
		carRepository.saveAll(cars);
		carRepository.findAll().forEach(car -> logger.info(car.getMake()+" "+car.getBrand()));

	}
	// ORM - (Object Relational Mapping) is a technique that allow you tp fetch from and manipulate a database.
	// By using OOP paradigm. -> Hibernate!!
	// JPA - Java Presistant API -

}
