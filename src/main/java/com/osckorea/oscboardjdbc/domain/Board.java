package com.osckorea.oscboardjdbc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("board") // POJO 데이터베이스 테이블과 일치해야한다.
public class Board {
    // POJO 클래스입니다.

    @Id // 기본키 식별을 하기위해 붙여준다.
    @Generated
    private Long id;
    private String title; // 제목
    private String contents; // 내용


    public void patch(Board boardArticle) {
        if ( boardArticle.title != null)
            this.title = boardArticle.title;
        if ( boardArticle.contents != null)
            this.contents = boardArticle.contents;
    }
}
