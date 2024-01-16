package com.binary.carShow.service;

import com.binary.carShow.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();

    Car getCarById(Long id);
}
