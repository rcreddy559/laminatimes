package com.laminatimes.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.laminatimes.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	Optional<UserRole> findByUserId(int userId);

}
