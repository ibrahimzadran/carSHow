package com.binary.carShow.repository;

import com.binary.carShow.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    //CRUD
    //Rest ( Representational State Transfer)
    // is an architectural style for create web services.
    // stateless: The server does not hold any information about the client state.
    // // Client and server :
    // cacheable
    // Uniform Interface:
    // Layered System:
    // Code on Demand




}
