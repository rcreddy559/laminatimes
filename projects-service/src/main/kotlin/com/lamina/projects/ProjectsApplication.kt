package com.lamina.projects

import com.lamina.projects.controller.ProjectsController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ProjectsApplication

fun main(args: Array<String>) {
	runApplication<ProjectsApplication>(*args)
}
