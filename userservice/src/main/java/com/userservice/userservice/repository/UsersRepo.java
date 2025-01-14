package com.userservice.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.userservice.model.Users;

public interface UsersRepo extends JpaRepository<Users, String>{

}
