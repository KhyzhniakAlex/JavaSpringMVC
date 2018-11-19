package com.labs.maven.spring.LabSpring.Controllers;

import com.labs.maven.spring.LabSpring.Models.Car;
import com.labs.maven.spring.LabSpring.Repositories.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRep;

    public CarController(CarRepository carRep) {
        this.carRep = carRep;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView DETAIL(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("index");

        model.addObject("car", carRep.findById(id).get());

        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllCar() {
        ModelAndView model = new ModelAndView("index");

        model.addObject("CarList", carRep.findAll());

        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView CREATE(@RequestBody Car car){

        carRep.save(car);
        return new ModelAndView("redirect:/car");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UPDATE(@RequestBody Car newCar, @PathVariable Integer id){

        carRep.findById(id)
                .map(car -> {
                    car.setBrand(newCar.getBrand());
                    car.setModel(newCar.getModel());
                    car.setPrise(newCar.getPrise());
                    car.setColor(newCar.getColor());
                    return carRep.save(car);
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return carRep.save(newCar);
                });

        return new ModelAndView("redirect:/car");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView DELETE(@PathVariable Integer id){

        carRep.deleteById(id);
        return new ModelAndView("redirect:/car");
    }
}