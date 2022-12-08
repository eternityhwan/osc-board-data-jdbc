CREATE DATABASE oscjdbc;

CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `contents` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

INSERT INTO `board` (id, title, contents)
VALUES
(1, '제목1','JDBC 프로젝트1' ),
(2, '제목2', 'JDBC 프로젝트2'),
(3, '제목3', 'JDBC 프로젝트3');

commit;

/**
데이터 베이스 목록 보기
SHOW DATABASES;

데이터 베이스 삭제
DROP DATABASE oscjdcb;

데이터 베이스 사용
USE oscjdcb

테이블 삭제

DROP TABLE 테이블이름;

테이블 생성

CREATE TABLE 테이블이름;
 */
