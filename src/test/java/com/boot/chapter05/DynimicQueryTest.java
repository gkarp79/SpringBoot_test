package com.boot.chapter05;


import com.boot.chapter05.domain.Board;
import com.boot.chapter05.domain.QBoard;
import com.boot.chapter05.persistence.DynimicBoardRepository;
import com.querydsl.core.BooleanBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynimicQueryTest {
    @Autowired private DynimicBoardRepository boardRepo;

    @Test
    public void testDynamicQuery(){
        String searchCondition = "CONTENT";
        String searchKeyword = "테스트 제목 10";

        BooleanBuilder builder = new BooleanBuilder();

        QBoard board = QBoard.board;

        if(searchCondition.equals("TITLE")){
            builder.and(board.title.like("%"+ searchKeyword+"%"));
        } else if (searchCondition.equals("CONTENT")) {
            builder.and(board.title.like("%" + searchKeyword + "%"));

        }

        Pageable paging = PageRequest.of(0,5);

        Page<Board> boardList =  boardRepo.findAll(builder,paging);

        System.out.println("검색 결과");

        for(Board board1 : boardList){
            System.out.println("------> " + board1.toString());
        }
    }
}
