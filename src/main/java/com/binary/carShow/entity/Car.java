package com.binary.carShow.entity;

import jakarta.persistence.*;
import org.aspectj.asm.IModelFilter;
@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "car_Id")
    private Long id;
    private String make;
    private String brand;
    private String model;
    private String registerNumber;
    private int year;
    private double price;

    public Car() {

    }

    public Car( String make, String brand, String model, String registerNumber, int year, double price) {

        this.id = id;
        this.make = make;
        this.brand = brand;
        this.model = model;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registerNumber='" + registerNumber + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
