package com.gtman5.test.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardRepoTest {

    @Autowired
    private BoardRepo boardRepo;

    @AfterEach
    public void afterAll() {
        boardRepo.deleteAll();
    }

    @Test
    public void read() {
        String title = "테스트 게시글";
        String content = "테스트 본문임.";

        boardRepo.save(Board.builder().title(title).content(content).writer("한재종").build());

        List<Board> boardList = boardRepo.findAll();
        Board board = boardList.get(0);

        Assertions.assertEquals(board.getTitle(), title);
        Assertions.assertEquals(board.getContent(), content);
    }
}
