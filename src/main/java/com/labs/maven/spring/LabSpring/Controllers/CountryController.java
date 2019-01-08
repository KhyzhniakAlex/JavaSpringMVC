package com.labs.maven.spring.LabSpring.Controllers;

import com.labs.maven.spring.LabSpring.Models.Country;
import com.labs.maven.spring.LabSpring.Repositories.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRep;

    public CountryController(CountryRepository countryRep) {
        this.countryRep = countryRep;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView DETAIL(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("countryDetail");

        model.addObject("Country", countryRep.findById(id).get());

        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllCountry() {
        ModelAndView model = new ModelAndView("countryAll");

        List<Country> country = (List<Country>) countryRep.findAll();

        model.addObject("CountryList", country);

        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView CREATE(@ModelAttribute Country country){

        countryRep.save(country);
        return new ModelAndView("redirect:/country");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UPDATE(@ModelAttribute Country newCountry, @PathVariable Integer id){

        countryRep.findById(id)
                .map(country -> {
                    country.setName(newCountry.getName());
                    country.setRegion(newCountry.getRegion());
                    country.setPopulation(newCountry.getPopulation());
                    return countryRep.save(country);
                })
                .orElseGet(() -> {
                    newCountry.setId(id);
                    return countryRep.save(newCountry);
                });

        return new ModelAndView("redirect:/country");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView DELETE(@PathVariable Integer id){

        countryRep.deleteById(id);
        return new ModelAndView("redirect:/country");
    }
}

