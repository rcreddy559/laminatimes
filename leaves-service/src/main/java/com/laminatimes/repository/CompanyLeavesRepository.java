package com.laminatimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laminatimes.leaves.entity.CompanyLeaves;


public interface CompanyLeavesRepository extends JpaRepository<CompanyLeaves, Integer> {

}
