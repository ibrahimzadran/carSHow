package com.binary.carShow.service;

import com.binary.carShow.entity.Owner;
import com.binary.carShow.repository.OwnerRepository;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface OwnerService {

    List<Owner> getOwner();
    Owner getCarById(Long id);

    Owner addOwner(Owner owner);

    void deleteOwnerById(Long id);

    Owner updateOwnerById(Long id, Owner owner);



}
