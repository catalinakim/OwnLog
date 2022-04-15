package com.catalina.ownlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends TimeStamp{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long no;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;
}
