package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name="board")
@Table (name="posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostEntity {

    @Id
    @Column(name="post_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postCode;

    @Column(name="page_id")
    private String pageId;

    @Column(name="post_title")
    private String postTitle;

    @Column(name="post_content")
    private String postContent;

    @Column(name="page_nickname")
    private String pageNickname;

    @Column(name="post_createdAt")
    private LocalDateTime postCreatedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

}
