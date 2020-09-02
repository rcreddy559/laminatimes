package com.lamina.projects.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/project")
class ProjectsController {

    fun isOctogenarian(age: Int): Boolean = age in 80..89
    @GetMapping
    fun projects() : List<Project>? {

        return arrayListOf(Project(1, "Ravi", "Ravi description"));
    }
}

