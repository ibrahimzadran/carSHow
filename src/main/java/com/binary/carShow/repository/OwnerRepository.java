package com.binary.carShow.repository;

import com.binary.carShow.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {


    Owner findOwnerByFirstName(String firstName);

}
