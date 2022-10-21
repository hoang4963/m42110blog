package com.codegym.blog.respository.blog;

import com.codegym.blog.model.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IBlogRespository extends CrudRepository<Blog, Long> {
    @Transactional
    @Modifying
    @Query("update Blog b set b.name = ?1, b.detail = ?2")
    public Blog updateNameAndDetailBy(String name, String detail);
}
