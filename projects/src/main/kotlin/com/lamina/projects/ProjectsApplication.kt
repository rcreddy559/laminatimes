package com.lamina.projects

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectsApplication

fun main(args: Array<String>) {
	runApplication<ProjectsApplication>(*args)
}
