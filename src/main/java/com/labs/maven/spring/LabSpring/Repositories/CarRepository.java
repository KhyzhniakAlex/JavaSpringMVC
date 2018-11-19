package com.labs.maven.spring.LabSpring.Repositories;

import com.labs.maven.spring.LabSpring.Models.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}