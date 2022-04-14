package com.catalina.ownlog.model;

import lombok.Getter;

@Getter
public class CommentDto {
    private Long boardId;
    private String name;
    private String comment;
}
