package com.labs.maven.spring.LabSpring.Controllers;

import com.labs.maven.spring.LabSpring.Models.Weapon;
import com.labs.maven.spring.LabSpring.Repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/weapon")
public class WeaponController {

    @Autowired
    private WeaponRepository wepRep;

    public WeaponController(WeaponRepository wepRep) {
        this.wepRep = wepRep;
    }

    @GetMapping
    public List<Weapon> getListWeapon() {
        return (List<Weapon>) wepRep.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Weapon> getWeapon(@PathVariable Integer id) {
        return wepRep.findById(id);
    }

    @PostMapping
    public Weapon create(@RequestBody Weapon weapon){
        return wepRep.save(weapon);
    }

    @PutMapping("/{id}")
    public Weapon update(@RequestBody Weapon newWeapon, @PathVariable Integer id){
            return wepRep.findById(id)
                    .map(weapon -> {
                        weapon.setName(newWeapon.getName());
                        weapon.setBrand(newWeapon.getBrand());
                        weapon.setRate(newWeapon.getRate());
                        weapon.setCaliber(newWeapon.getCaliber());
                        return wepRep.save(weapon);
                    })
                    .orElseGet(() -> {
                        newWeapon.setId(id);
                        return wepRep.save(newWeapon);
                    });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try{
            wepRep.deleteById(id);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}


