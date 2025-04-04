package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CommentEntity {

    @Id
    @Column(name="post_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postCode;


    @Column(name="page_id") // 회원 아이디
    private String pageId;

    @Column(name="comment_content")
    private String commentContent;

    @Column(name="page_nickname")
    private String pageNickname;

    @ManyToOne
    @JoinColumn(name = "post_code")
    private PostEntity post;
}
