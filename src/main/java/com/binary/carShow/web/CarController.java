package com.binary.carShow.web;

import com.binary.carShow.entity.Car;
import com.binary.carShow.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
   private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carService.getCars();
    }



}
