package com.projects.controller;

import com.projects.entity.Project;
import com.projects.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService service;

    @GetMapping
    public List<Project> getProjects() {
        return service.getProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        return new ResponseEntity(service.getProject(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Project project) {
        service.create(project);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Project project) {
        service.update(project);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
