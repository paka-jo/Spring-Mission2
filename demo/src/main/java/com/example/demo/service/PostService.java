package com.example.demo.service;

import com.example.demo.Model.PostEntity;
import com.example.demo.config.PostMapper;
import com.example.demo.dto.PostDTO;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("postServiceField")
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    ;

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

    //리다이렉트 할때 게시판 목록에 필요한 정보들에 대해서만 불러오기 위한 메소드
    public List<PostDTO> findAllPostForList() {
        List<PostEntity> postList = postRepository.findAll();
        return postList.stream()
                .map(post -> new PostDTO(post.getPostCode(), post.getPostTitle(), post.getPageNickname(), post.getPostCreatedAt()))
                .collect(Collectors.toList());
    }

    public PostDTO findPostById(Long id) {
        // 예시. 실제로는 Repository에서 데이터 가져오는 코드가 필요
        return postRepository.findById(id)
                .map(PostMapper::toDto)
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
    }

}


