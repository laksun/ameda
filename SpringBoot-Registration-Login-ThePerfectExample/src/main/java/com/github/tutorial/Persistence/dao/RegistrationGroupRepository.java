package com.github.tutorial.Persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.tutorial.Persistence.model.RegistrationGroup;

@Repository("registrationGroupRepository")
public interface RegistrationGroupRepository  extends JpaRepository<RegistrationGroup, Integer>{

		RegistrationGroup findByName(String name);
}
