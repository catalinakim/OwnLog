package com.catalina.ownlog.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardId(Long boardId);
//    List<Comment> findAllByBoardIdByDateWriteDesc(Long boardId);
//    No property 'byDateWriteDesc' found for type 'Long'! Traversed path: Comment.boardId.
    List<Comment> findAllByBoardIdOrderByDateWriteDesc(Long boardId);
//    public List<Pilot> findTop10ByOrderByLevelDesc();
}
