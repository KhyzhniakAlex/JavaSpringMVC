package com.labs.maven.spring.LabSpring.Controllers;

import com.labs.maven.spring.LabSpring.Models.Authorities;
import com.labs.maven.spring.LabSpring.Models.Users;
import com.labs.maven.spring.LabSpring.Repositories.RoleService;
import com.labs.maven.spring.LabSpring.Repositories.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EnterController {

    @Autowired
    UserService userRep;

    @Autowired
    RoleService roleRep;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username or password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "index";
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, String error, String logout) {
        return "index";
    }*/

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model) {
        return "menu";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration_post(@ModelAttribute Users users, String role) {
        users.setEnabled(true);
        userRep.save(users);
        Authorities a = new Authorities(users.getUsername(),"ROLE_"+role.toUpperCase());
        roleRep.save(a);
        return "redirect:/";
    }
}
