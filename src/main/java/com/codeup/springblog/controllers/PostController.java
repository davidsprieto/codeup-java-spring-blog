package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
//
//    End of Spring - Fundamentals: Views Exercises
//
////    OLD postForm() METHOD
//    @GetMapping("/posts/create")
//    public String postForm() {
//        return "posts/create";
//    }

////    OLD createPost() METHOD
//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
//        Post newPost = new Post();
//        User user = usersRepository.getById(1L);
//        newPost.setTitle(title);
//        newPost.setBody(body);
//        newPost.setUser(user);
//        postsRepository.save(newPost);
//        return "redirect:/posts";
//    }


    private final PostRepository postsRepository;
    private final UserRepository usersRepository;

    public PostController(PostRepository postsRepository, UserRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postsRepository.findAll());
        return "posts/index";
    }

//  NEW postForm() METHOD
    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = usersRepository.getById(1L);
        post.setUser(user);
        postsRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping ("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        User user = usersRepository.getById(1L);
        model.addAttribute("user", user);
        Post post = postsRepository.getById(id);
        model.addAttribute("posts", post);
        return "posts/show";
    }

    @GetMapping("posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsRepository.getById(id));
        return "posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        User user = usersRepository.getById(1L);
        post.setUser(user);
        postsRepository.save(post);
        return "redirect:/posts";
    }

}
