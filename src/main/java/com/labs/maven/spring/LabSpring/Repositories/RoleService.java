package com.labs.maven.spring.LabSpring.Repositories;

import com.labs.maven.spring.LabSpring.Models.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleService extends JpaRepository<Authorities,Integer> {
    //Authorities findByUsername(final String username);
}
