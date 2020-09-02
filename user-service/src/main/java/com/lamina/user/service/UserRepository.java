package com.lamina.user.service;

import com.lamina.user.controller.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamina.user.controller.User;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {

}
