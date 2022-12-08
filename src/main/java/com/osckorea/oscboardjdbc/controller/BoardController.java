package com.osckorea.oscboardjdbc.controller;

import com.osckorea.oscboardjdbc.domain.Board;
import com.osckorea.oscboardjdbc.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor // @오토와이어드 없어도 필드 선언 가능.
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    // Create 기능
    @PostMapping("/posts")
    public ResponseEntity<Board> addArticle(@RequestBody Board dto) {

        Board posts = boardService.createArticle(dto);

        return (posts != null) ?
            ResponseEntity.status(HttpStatus.OK).body(posts) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Read 기능
   @GetMapping("/list")
    public List<Board> boardList() {
        List<Board> boardList = boardService.boardList();
        return boardList;
    }
    // Read 기능
    @GetMapping("/{id}")
    public Board findArticle(@PathVariable Long id) {
        return boardService.findArticle(id);
    }
    //Update 기능
    @PutMapping("/update/{id}")
    public ResponseEntity<Board> updateArticle(
        @PathVariable Long id,
        @RequestBody Board dto) {

        Board updated = boardService.update(id,dto);
        return (updated != null) ?
            ResponseEntity.status(HttpStatus.OK).body(updated) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // Delete 기능
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {

        Board delete = boardService.delete(id);

        return (delete != null) ?
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
