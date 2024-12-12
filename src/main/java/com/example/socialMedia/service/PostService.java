package com.example.socialMedia.service;


import com.example.socialMedia.model.Post;
import com.example.socialMedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository PostRepository;

    public List<Post> getAllPosts() {
        return PostRepository.findAll();
    }

    public Post getPostById(Long id) {

        return PostRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post) {

        return PostRepository.save(post);
    }

    public void deletePost(Long id) {
        PostRepository.deleteById(id);
    }



}

