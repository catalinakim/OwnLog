package com.catalina.ownlog.service;

import com.catalina.ownlog.model.Comment;
import com.catalina.ownlog.model.CommentDto;
import com.catalina.ownlog.model.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentDto commentDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 댓글입니다")
        );
        comment.update(commentDto);
        return id;
    }
}
