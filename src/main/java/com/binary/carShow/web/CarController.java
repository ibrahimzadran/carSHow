package com.binary.carShow.web;

import com.binary.carShow.entity.Car;
import com.binary.carShow.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
   private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars(){
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
public ResponseEntity<Car> getCarById(@PathVariable Long id){
    return new ResponseEntity<>(carService.getCarById(id),HttpStatus.OK);
}
@PostMapping("/add")
public ResponseEntity<Car>  addCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.addCar(car),HttpStatus.CREATED);
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<Car>  deleteCarById (@PathVariable Long id){
        carService.deleteCarById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
}
@PutMapping("/{id}")
public ResponseEntity<Car> updateCarById(@PathVariable Long id,@RequestBody Car car){
        return new ResponseEntity<>(carService.updateCarById(id,car),HttpStatus.ACCEPTED);
}
}
