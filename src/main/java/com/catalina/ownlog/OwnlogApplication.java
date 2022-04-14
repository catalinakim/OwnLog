package com.catalina.ownlog;

import com.catalina.ownlog.model.Board;
import com.catalina.ownlog.model.BoardDto;
import com.catalina.ownlog.model.BoardRepository;
import com.catalina.ownlog.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing  //생성시간 바꼈을때 자동으로 업데이트
@SpringBootApplication
public class OwnlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OwnlogApplication.class, args);
    }

    //더미데이터
    @Bean
    public CommandLineRunner demo(BoardRepository boardRepository, BoardService boardService) {
        return (args) -> {
//            boardRepository.save(new Board("제목입니다.", "튤립", "내용입니다."));
//            boardRepository.save(new Board("제목입니다.2", "조나단", "내용입니다.2"));

//            List<Board> courseList = boardRepository.findAll();
//            List<Board> courseList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "dateWrite"));
//            for (int i = 0; i < courseList.size(); i++) {
//                Board board = courseList.get(i);
//                System.out.println(board.getId());
//                System.out.println(board.getTitle());
//                System.out.println(board.getDateWrite());
//            }


        };
    }
}
