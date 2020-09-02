package com.laminatimes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laminatimes.leaves.entity.Leaves;

public interface LeavesRepository extends JpaRepository<Leaves, Integer>{
	 Page<Leaves> findByCreatedBy(Integer id, Pageable pageable);
}
