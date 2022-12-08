package com.osckorea.oscboardjdbc.service;

import com.osckorea.oscboardjdbc.domain.Board;
import com.osckorea.oscboardjdbc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // Create 기능
    public Board createArticle(Board dto) {
        Board board = boardRepository.save(dto);
        // 아이디가 존재하면 null을 반환해라.
        if (board.getId() != null) {
            return null;
        }
        return board;
    }

    // Read 기능
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    // Read by id
    public Board findArticle(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    // Update 기능
    @Transactional public Board update(Long id, Board dto) {

        // 1. DB에서 데이터를 조회해서 객체로 저장한다.
        Optional<Board> boardArticle = boardRepository.findById(id);
        // 2. 가져온 데이터에 수정할 정보에 데이터를 넘긴다.
        if (boardArticle.isPresent()) {
            Board extractInfo = boardArticle.get();
            extractInfo.setTitle(dto.getTitle());
            extractInfo.setContents(dto.getContents());
            // 3. DB에 저장한다
            Board updated = boardRepository.save(extractInfo);

            return updated;
        }
        return Board.builder().build();
    }
    // Delete 기능
    public Board delete(Long id) {

        // 1. 삭제 글 찾기
        Board deleteArticle = boardRepository.findById(id).orElse(null);

        // 2. 잘못된 요청 처리
        if (deleteArticle == null) {
            return null;
        }
        // 3. 대상 삭제
        boardRepository.delete(deleteArticle);
        return deleteArticle;
    }
}

