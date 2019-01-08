package com.labs.maven.spring.LabSpring.Repositories;

import com.labs.maven.spring.LabSpring.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<Users, Integer> {

}
