package com.lamina.projects.controller

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Project(@Id var id: Int, var name:String, var description: String ) {
    constructor()  {}
}
