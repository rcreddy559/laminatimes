package com.projects.service;

import com.projects.entity.Project;
import com.projects.exception.ProjectsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {
    @Autowired
    ProjectsRepositry repositry;

    public List<Project> getProjects() {
        return repositry.findAll();
    }

    public Object getProject(Long id) {
        return repositry.findById(id).orElseThrow(() -> new ProjectsException("No Projects found with id " + id));
    }

    public void create(Project project) {
        repositry.save(project);
    }

    public void update(Project project) {
        Project p = repositry.findById(project.getId())
                .orElseThrow(() -> new ProjectsException("No Projects found with id " + project.getId()));

        p.setDescription(project.getDescription());
        p.setName(project.getName());
        repositry.save(p);
    }

    public void delete(Long id) {
        getProject(id);
        repositry.deleteById(id);
    }
}
