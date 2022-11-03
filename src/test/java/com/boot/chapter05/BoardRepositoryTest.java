package com.boot.chapter05;

import com.boot.chapter05.domain.Board;
import com.boot.chapter05.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired private BoardRepository boardRepo;

//    @Test
//    public void testInsertBoard(){
//        Board board = new Board();
//        board.setTitle("JPA제목");
//        board.setWriter("관리자");
//        board.setContent("JPA 글 등록 굿");
//        board.setCreateDate(new Date());
//        board.setCnt(0L);
//
//        boardRepo.save(board);
//    }

    @Test
    public void testGetBoard(){
        Board board = boardRepo.findById(1L).get();
        System.out.println(board.toString());
    }


    @Test
    public void testUpdateBoard(){
        Board board = boardRepo.findById(1L).get();
        System.out.println(board);

        board.setTitle("수정된 제목");
        boardRepo.save(board);
    }


    @Test
    public void testDeleteBoard(){
        boardRepo.deleteById(1L);
    }

}
