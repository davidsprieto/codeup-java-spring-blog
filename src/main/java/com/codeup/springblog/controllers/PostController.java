package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String indexPage() {
        return "This is the index page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewIndividualPost(@PathVariable int id) {
        return "The id is: " + id + "!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPostForm() {
        return "A form will be here to fill out and post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post!";
    }

}
