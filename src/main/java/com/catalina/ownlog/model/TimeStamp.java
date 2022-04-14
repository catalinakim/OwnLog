package com.catalina.ownlog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Getter
@MappedSuperclass  //공통으로 사용하는 속성, 엔티티(테이블에 대응하는 클래스)를 추출, 매핑 정보만 상속받음
@EntityListeners(AuditingEntityListener.class) //해당 클래스에 Auditing 기능
public abstract class TimeStamp {

    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime dateWrite;

    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동 저장
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime dateEdit;
}
