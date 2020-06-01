package com.laminatimes.admin.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.laminatimes.admin.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
	
	Optional<UserProfile>  findByEmpNumber(String empNumber);

}
