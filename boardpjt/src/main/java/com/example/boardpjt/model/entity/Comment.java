package com.example.boardpjt.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
public class Comment extends BaseEntity{ // audit -> 생성, 수정일자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) // EAGER : 즉시 로딩, LAZY : 지연 로딩
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount author; // 댓글의 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post; // 댓글이 달린 글

}
