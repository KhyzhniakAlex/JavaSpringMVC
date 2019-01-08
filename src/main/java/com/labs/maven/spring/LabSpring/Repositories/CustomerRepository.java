package com.labs.maven.spring.LabSpring.Repositories;

import com.labs.maven.spring.LabSpring.Models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}