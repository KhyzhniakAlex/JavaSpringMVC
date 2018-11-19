package com.labs.maven.spring.LabSpring.Repositories;

import com.labs.maven.spring.LabSpring.Models.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
