package com.projects.service;

import com.projects.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepositry extends JpaRepository<Project, Long> {
}
