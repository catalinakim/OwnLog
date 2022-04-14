package com.catalina.ownlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor  //기본 생성자 생성해줘
@Entity  //테이블 역할하는 클래스
public class Board extends TimeStamp{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    public Board(String title, String name, String content){  //더미데이터
        this.title = title;
        this.name = name;
        this.content = content;
    }

    public Board(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.name = boardDto.getName();
        this.content = boardDto.getContent();
    }

    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.name = boardDto.getName();
        this.content = boardDto.getContent();
    }


}
