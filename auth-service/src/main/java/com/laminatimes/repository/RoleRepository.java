package com.laminatimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.laminatimes.entity.Role;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	
	Role findByRole(String role);

    @Override
    List<Role> findAll();
}
