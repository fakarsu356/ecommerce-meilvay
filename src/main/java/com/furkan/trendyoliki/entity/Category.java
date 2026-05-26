package com.furkan.trendyoliki.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="categories")
public class Category {
    @NotNull
    private String name;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    public Category() {
    }
    public Category(@NotNull String name, Integer id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
