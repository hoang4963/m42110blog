package com.codegym.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name= "name")
    private String name;
    @Column(name = "detail")
    private String detail;

    public Blog(Long id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
    }

    public Blog() {
    }

    public Blog(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
