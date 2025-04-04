package com.example.demo.controller;

import com.example.demo.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PostController {

    @PostMapping("/posts")
    public ResponseEntity<Post> creatPost(@RequestBody Post post)
    {
        Post savedPost = PostService.creatPost(post);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long postId){
        Post post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }
}
