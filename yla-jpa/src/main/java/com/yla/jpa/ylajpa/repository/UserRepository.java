package com.yla.jpa.ylajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yla.jpa.ylajpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
