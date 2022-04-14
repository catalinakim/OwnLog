package com.catalina.ownlog.service;

import com.catalina.ownlog.model.Board;
import com.catalina.ownlog.model.BoardDto;
import com.catalina.ownlog.model.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardDto boardDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글은 존재하지 않습니다.")
        );
        board.update(boardDto);
        return id;
    }


}
