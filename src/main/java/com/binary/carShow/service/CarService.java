package com.binary.carShow.service;

import com.binary.carShow.entity.Car;
import com.binary.carShow.entity.Owner;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface CarService {
    List<Car> getCars();

    Car getCarById(Long id);

    Car addCar(Car car);

    void deleteCarById(Long id);

    Car updateCarById(Long id, Car car);
}
