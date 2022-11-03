package com.rubypaper;

import com.rubypaper.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class JPAClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
        EntityManager em = emf.createEntityManager();

        try {
            Board board = new Board();
            board.setTitle("JPA제목");
            board.setWriter("관리자");
            board.setContent("JPA 글 등록 굿");
            board.setCreateDate(new Date());
            board.setCnt(0L);

            em.persist(board);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
