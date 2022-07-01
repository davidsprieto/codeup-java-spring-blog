package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

//    Spring - Fundamentals: Controllers Exercises

//    @GetMapping("/posts")
//    @ResponseBody
//    public String indexPage() {
//        return "This is the index page!";
//    }
//
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String viewIndividualPost(@PathVariable int id) {
//        return "The id is: " + id + "!";
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String viewPostForm() {
//        return "A form will be here to fill out and post!";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "Create a new post!";
//    }

//    Spring - Fundamentals: Views Exercises
//
//    @GetMapping("/posts")
//    public String postsIndex(Model model) {
//        ArrayList<Post> posts = new ArrayList<>();
//        Post post2 = new Post("Friday", "Tomorrow is Friday.");
//        Post post3 = new Post("Saturday", "The day after tomorrow is Saturday.");
//        posts.add(post2);
//        posts.add(post3);
//
//        model.addAttribute("posts", posts);
//
//        return "posts/index";
//    }
//
//    @GetMapping ("/posts/{id}")
//    public String viewIndividualPost(@PathVariable int id, Model model) {
//        Post post1 = new Post("Thursday", "Today is Thursday.");
//        model.addAttribute("post", post1);
//        return "posts/show";
//    }

    private final PostRepository postsRepository;

    public PostController(PostRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postsRepository.findAll());
        return "posts/index";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Post newPost) {
        newPost.setTitle(title);
        newPost.setBody(body);
        postsRepository.save(newPost);
        return "redirect:/posts";
    }


}
