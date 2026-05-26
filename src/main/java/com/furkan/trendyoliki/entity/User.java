package com.furkan.trendyoliki.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

     @NotNull
    @Column(name="name")
    private  String name;
    @NotNull
    @Column(name="password")
    private String password;
    @NotNull
    @Column(name="email")
    private String email;

    @Column(name="role")
    private Role role;

    public User(Integer id, String name, String password, String email,Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role=role;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public User() {
    }
}
