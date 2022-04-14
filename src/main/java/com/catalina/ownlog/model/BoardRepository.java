package com.catalina.ownlog.model;

import org.springframework.data.jpa.repository.JpaRepository;

//어떤 객체를 대상으로 JPA 할꺼냐 Board,  id 타입은 Long
public interface BoardRepository extends JpaRepository<Board, Long>{
}


