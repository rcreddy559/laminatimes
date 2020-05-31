package com.laminatimes.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laminatimes.admin.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	
	Role findByRole(String role);


  }
