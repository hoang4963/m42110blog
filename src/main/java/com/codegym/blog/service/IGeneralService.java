package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    Blog save(T t);

    void remove(Long id);

    void update(Blog blog);
}
