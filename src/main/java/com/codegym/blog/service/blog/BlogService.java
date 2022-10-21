package com.codegym.blog.service.blog;

import com.codegym.blog.model.Blog;
import com.codegym.blog.respository.blog.IBlogRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BlogService implements IBlogService {

    @Autowired
    IBlogRespository blogRespository;
    @Override
    public List<Blog> findAll() {
      return (List<Blog>) blogRespository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
       return blogRespository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
       return blogRespository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRespository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRespository.updateNameAndDetailBy(blog.getName(), blog.getDetail());
    }
}
