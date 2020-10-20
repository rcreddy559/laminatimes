package com.laminatimes.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laminatimes.leaves.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

		
	 Stream<User> findByFirstName(String name);

}
