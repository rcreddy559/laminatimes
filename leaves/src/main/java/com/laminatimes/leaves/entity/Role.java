package com.laminatimes.leaves.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="role_name")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> UserProfiles;


    public Collection<User> getUserProfiles() {
        return UserProfiles;
    }

    public void setUserProfiles(Collection<User> UserProfiles) {
        this.UserProfiles = UserProfiles;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


}