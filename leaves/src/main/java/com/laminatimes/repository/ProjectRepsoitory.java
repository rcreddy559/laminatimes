package com.laminatimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.laminatimes.leaves.entity.Project;


public interface ProjectRepsoitory extends JpaRepository<Project, Integer> {

}
