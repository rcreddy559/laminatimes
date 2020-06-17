package com.projects.controller;

import com.projects.entity.Project;
import com.projects.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectsController {


    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.env.prod: default value }")
    private String defaultValue;

    @Value("This is static value")
    private String staticValue;

    @Value("#{${sping.map.dbvalues}}")
    private Map<String, String> dbValues;

    @Autowired
    private ProjectsService service;

    @GetMapping
    public List<Project> getProjects() {

        System.out.println("applicationName: "+applicationName);
        System.out.println("defaultValue: "+defaultValue);
        System.out.println("staticValue: "+staticValue);
        System.out.println("dbValues:"+dbValues);

        return service.getProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
//        try {
//            Thread.sleep(300000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new ResponseEntity(service.getProject(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Project project) {
        System.out.println("----------- create-------------------");
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
