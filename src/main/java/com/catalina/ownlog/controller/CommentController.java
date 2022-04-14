package com.catalina.ownlog.controller;

import com.catalina.ownlog.model.Comment;
import com.catalina.ownlog.model.CommentDto;
import com.catalina.ownlog.model.CommentRepository;
import com.catalina.ownlog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/comment")
    public Comment writeComment(@RequestBody CommentDto commentDto){
        Comment comment = new Comment(commentDto);
        commentRepository.save(comment);
        return comment;
    }

    @GetMapping("/commentList/{boardId}") //게시글 번호를 알아야 그 댓글 가져오지
    public List<Comment> getCommentList(@PathVariable Long boardId){
//        return commentRepository.findAllByBoardId(boardId);
        return commentRepository.findAllByBoardIdOrderByDateWriteDesc(boardId);
//        return commentRepository.findAllByBoardId(Long boardId, Sort.by(Sort.Direction.DESC,"dateWrite"));
    }

    @GetMapping("/comment/{id}")
    public Comment getComment(@PathVariable Long id){
        return commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("없는 댓글입니다.")
        );
    }

    @PutMapping("/comment/{id}")
    public Long editComment(@PathVariable Long id, @RequestBody CommentDto commentDto){
        return commentService.update(id, commentDto);
    }

    @DeleteMapping("/comment/{id}")
    public Long delComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
