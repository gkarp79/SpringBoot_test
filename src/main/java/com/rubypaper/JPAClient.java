package com.rubypaper;

import com.rubypaper.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class JPAClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
////등록
//        try {
//            tx.begin();
//
//            Board board = new Board();
//            board.setTitle("JPA제목");
//            board.setWriter("관리자");
//            board.setContent("JPA 글 등록 굿");
//            board.setCreateDate(new Date());
//            board.setCnt(0L);
//
//            em.persist(board);
//
//            tx.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            tx.rollback();
//        }finally {
//            em.close();
//            emf.close();
//        }

//        try{
//            Board searchBoard = em.find(Board.class, 1L);
//            System.out.println("---->" + searchBoard.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            em.close();
//            emf.close();
//        }
////삭제와 수정
//        try{
//            tx.begin();
//
////            수정
////            Board board = em.find(Board.class, 1L);
////
////            board.setTitle("변경된 타이틀");
////
////            tx.commit();
//            Board board = em.find(Board.class, 1L);
//
////            board.setSeq(1L);
//            em.remove(board);
//            tx.commit();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            tx.rollback();
//        }finally {
//            em.close();
//            emf.close();
//        }

        try{
            tx.begin();

            Board board = new Board();
            board.setTitle("JPA제목");
            board.setWriter("관리자");
            board.setContent("JPA 글 등록 굿");
            board.setCreateDate(new Date());
            board.setCnt(0L);

            em.persist(board);

            tx.commit();

            String jpql = "Select b from Board b order by b.seq desc";
            List<Board> boardList = em.createQuery(jpql).getResultList();

            for(Board brd : boardList){
                System.out.println("--------------->" + brd.toString());
            }


        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
