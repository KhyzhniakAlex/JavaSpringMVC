package com.labs.maven.spring.LabSpring.Controllers;

import com.labs.maven.spring.LabSpring.Models.Country;
import com.labs.maven.spring.LabSpring.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRep;

    public CountryController(CountryRepository countryRep) {
        this.countryRep = countryRep;
    }

    @GetMapping
    public List<Country> getListCountry() {
        return (List<Country>) countryRep.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> getCountry(@PathVariable Integer id) {
        return countryRep.findById(id);
    }

    @PostMapping
    public Country create(@RequestBody Country country){
        return countryRep.save(country);
    }

    @PutMapping("/{id}")
    public Country update(@RequestBody Country newCountry, @PathVariable Integer id){
           return countryRep.findById(id)
                    .map(county -> {
                        county.setName(newCountry.getName());
                        county.setRegion(newCountry.getRegion());
                        county.setPopulation(newCountry.getPopulation());
                        return countryRep.save(county);
                    })
                    .orElseGet(() -> {
                        newCountry.setId(id);
                        return countryRep.save(newCountry);
                    });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try{
            countryRep.deleteById(id);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}

