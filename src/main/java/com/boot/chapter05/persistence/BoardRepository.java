package com.boot.chapter05.persistence;

import com.boot.chapter05.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BoardRepository extends CrudRepository<Board,Long> {
    List<Board> findByTitle(String searchKeyword);

    List<Board> findByContentContaining(String searchKeyword);

    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

//    List<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

//    @Query("SELECT b FROM Board b where b.title like %?1% order by b.seq desc")
//    List<Board> queryAnnotationTest1(String searchKeyword);
//
//    @Query("SELECT b FROM Board b where b.title like %:searchKeyword% order by b.seq desc")
//    List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
//
//    @Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//    List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);
//
//
//    @Query(value = "SELECT seq, title, writer, create_Date FROM Board WHERE title like '%'||?1||'%' ORDER BY seq DESC", nativeQuery = true)
//    List<Object[]> queryAnnotationTest4(String searchKeyword);
//
//    @Query(value = "SELECT b FROM Board b ORDER BY b.seq DESC")
//    List<Board> queryAnnotationTest5(Pageable paging);
}
