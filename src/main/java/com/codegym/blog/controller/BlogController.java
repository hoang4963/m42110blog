package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView =new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "Blog was added");
        return modelAndView;
    }
    @GetMapping("/blogs")
    public ModelAndView listBlogs(){
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
    @GetMapping("/delete-blog")
    public ModelAndView deleteBlog(@PathVariable Long id){
        blogService.remove(id);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs", blogList);
        modelAndView.addObject("message","delete done");
        return modelAndView;
    }
    @GetMapping("/edit-blog")
    public ModelAndView updateBlog(@RequestParam int id){
        Blog blogEdit = blogService.findAll().get(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit", "blogEdit", blogEdit);
        return modelAndView;
    }
    @PostMapping("/edit-blog")
    public ModelAndView editBlog(@ModelAttribute("blogEdit") Blog blogEdit){
        blogService.update(blogEdit);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs", blogList);
        modelAndView.addObject("message", "edit done");
        return modelAndView;
    }
    @GetMapping("/view-blog")
    public ModelAndView viewBlog(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        Optional<Blog> blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
