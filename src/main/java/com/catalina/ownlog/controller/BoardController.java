package com.catalina.ownlog.controller;

import com.catalina.ownlog.model.Board;
import com.catalina.ownlog.model.BoardDto;
import com.catalina.ownlog.model.BoardRepository;
import com.catalina.ownlog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/board")
    public Board writeBoard(@RequestBody BoardDto boardDto){
        Board board = new Board(boardDto);
        boardRepository.save(board);  //return saved entities
        return board;
    }

    @GetMapping("/board")
    public List<Board> getBoardList(){
//        return boardRepository.findAll();
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "dateWrite"));
//        public List<StudentEntity> findAllByOrderByIdAsc();
//        public List<Pilot> findTop10ByOrderByLevelDesc();
    }

    @GetMapping("/board/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardRepository.findById(id).orElseThrow(
            () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
    }
    /*
    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    //게시글 상세
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);
        model.addAttribute("boardDto", boardDTO);
        return "board/detail";
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
    // class PostsService
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(
            ()->new IllegalArgumentException("해당 사용자가 없습니다. id = "+id));
        return new PostsResponseDto(entity);
    }
     */

    @PutMapping("/board/{id}")
    public Long editBoard(@PathVariable Long id, @RequestBody BoardDto boardDto){
        return boardService.update(id, boardDto);
    }

    @DeleteMapping("/board/{id}")
    public Long delBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }

}
