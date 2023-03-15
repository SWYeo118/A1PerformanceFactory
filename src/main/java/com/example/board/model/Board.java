package com.example.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    // 글 번호
    private Long contentNumber;
    // 유저의 인덱스
    private Long userIdx;
    // 유저의 닉네임
    private String nickName;
    // 글의 제목
    private String title;
    // 글의 내용
    private String content;

    public Board(String nickName, String title, String content) {
        this.nickName = nickName;
        this.title = title;
        this.content = content;
    }

    // 기본생성자
    public Board() {

    }
}
