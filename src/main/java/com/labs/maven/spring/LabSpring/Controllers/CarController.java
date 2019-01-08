package com.labs.maven.spring.LabSpring.Controllers;

import com.labs.maven.spring.LabSpring.Models.Car;
import com.labs.maven.spring.LabSpring.Repositories.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        ModelAndView model = new ModelAndView("carDetail");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addObject("name", name);

        model.addObject("Car", carRep.findById(id).get());
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCar(Model model, String error, String logout) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("name", name);

        model.addAttribute("CarList", carRep.findAll());
        return "carAll";
    }

    /*@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView CREATE(@RequestParam(value="brand") String brand,
                               @RequestParam(value="model") String model,
                               @RequestParam(value="prise") int prise,
                               @RequestParam(value="color") String color){

        Car car = new Car(brand, model, prise, color);
        carRep.save(car);
        return new ModelAndView("redirect:/car");
    }*/

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView CREATE(@ModelAttribute Car car){

        carRep.save(car);
        return new ModelAndView("redirect:/car");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UPDATE(@ModelAttribute Car newCar, @PathVariable Integer id){

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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView DELETE(@PathVariable Integer id){

        carRep.deleteById(id);
        return new ModelAndView("redirect:/car");
    }
}