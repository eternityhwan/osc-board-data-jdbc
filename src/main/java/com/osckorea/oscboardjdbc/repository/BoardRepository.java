package com.osckorea.oscboardjdbc.repository;

import com.osckorea.oscboardjdbc.domain.Board;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    @Override
    List<Board> findAll();

    // 네이티브 쿼리.
    // spring data jdbc -- 이게 왜 생겼는가.
    // jpa
    // orm으로 sql을 안써도 되니까 쓴다.
    // msa가 아닌 환경에서 jpa 안쓰려면?
    // 쿼리 써야한다.
    // jpa - 컬렉션 함수를 쓰는데 좋지않다.
    // 쿼리로하면 컬렉션 함수를 쓸 수 있다.
    // 테이블 조인이 곤란한 상황? -> mybatis 쓰면됨!
    // jpa -- entity가 테이블이 생성됨.
    // msa환경 테이블 많아봐야 3~4개 - jpa 가능.
    // jpa 단점 어려움.
    // 복잡한 요소를 빼고 단반향으로 쓰자 나온 것이 spring data jdbc.
    // jpa의 복잡한 요소를 다 뺀 것임.
    // jdbc 방식은 쿼리가 어렵다.
    // 네이티브 쿼리 -- 레파지토리 기반에서 어노테이션으로 쓸 수 있다.
    // 전제 조건이있다 --- msa 환경처럼 table이 적고 쿼리가 적은 환경에서
    // spring-data-jdbc 쓴다.
    // 조인을 할거면 api로 한다.
}
