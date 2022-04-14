package com.catalina.ownlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "COMMENT_SEQ_GENERATOR",
        sequenceName = "COMMENT_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1,
        allocationSize = 1)
//https://gmlwjd9405.github.io/2019/08/12/primary-key-mapping.html
public class Comment extends TimeStamp {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ_GENERATOR")
    @Id
    private Long id;

    @Column(nullable = false)
    private Long boardId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentDto commentDto){
        this.boardId = commentDto.getBoardId();
        this.name = commentDto.getName();
        this.comment = commentDto.getComment();
    }

    public void update(CommentDto commentDto){
        // this.boardId = commentDto.getBoardId(); //확인필요
        this.name = commentDto.getName();
        this.comment = commentDto.getComment();
    }

}
