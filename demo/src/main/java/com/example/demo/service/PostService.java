package com.example.demo.service;

import com.example.demo.Model.CommentEntity;
import com.example.demo.Model.PostEntity;
import com.example.demo.dto.PostDTO;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("postServiceField")
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public PostService(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    public PostEntity savePost(PostDTO postDTO) {

        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        return postRepository.save(postEntity);
    }


    public List<PostDTO> findAllPost() {

        List<PostEntity> postList = postRepository.findAll();

        return postList.stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }
}


