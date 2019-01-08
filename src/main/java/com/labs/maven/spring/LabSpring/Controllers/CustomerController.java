package com.labs.maven.spring.LabSpring.Controllers;

import com.labs.maven.spring.LabSpring.Models.Customer;
import com.labs.maven.spring.LabSpring.Repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository custRep;

    public CustomerController(CustomerRepository custRep) {
        this.custRep = custRep;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView DETAIL(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("customerDetail");

        model.addObject("Customer", custRep.findById(id).get());

        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllCustomer() {
        ModelAndView model = new ModelAndView("customerAll");

        model.addObject("CustomerList", custRep.findAll());

        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView CREATE(@ModelAttribute Customer customer){

        custRep.save(customer);
        return new ModelAndView("redirect:/customer");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UPDATE(@ModelAttribute Customer newCustomer, @PathVariable Integer id){

        custRep.findById(id)
                .map(customer -> {
                    customer.setFirstname(newCustomer.getFirstname());
                    customer.setSurname(newCustomer.getSurname());
                    customer.setAge(newCustomer.getAge());
                    customer.setClient_number(newCustomer.getClient_number());
                    return custRep.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return custRep.save(newCustomer);
                });

        return new ModelAndView("redirect:/customer");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView DELETE(@PathVariable Integer id){

        custRep.deleteById(id);
        return new ModelAndView("redirect:/customer");
    }
}


