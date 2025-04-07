package com.example.demo.controller;

import com.example.demo.Model.PostEntity;
import com.example.demo.dto.PostDTO;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sub")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;



    @GetMapping("/list")
    public  String findPostList(Model model) {
        List<PostDTO> postList = postService.findAllPost();

        model.addAttribute("postList",postList);

        return "sub/list";
    }

    @PostMapping("/posts") //게시글 생성
    public String createPost(@ModelAttribute PostDTO createPost) {
        postService.savePost(createPost);

        return "sub/posts";
    }








}
