package com.example.socialMedia.controller;


import com.example.socialMedia.model.Post;
import com.example.socialMedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService PostService;

    @GetMapping("/getAll")
    public List<Post> getAllPosts() {
        return PostService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return PostService.getPostById(id);
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return PostService.createPost(post);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        PostService.deletePost(id);
    }

}
