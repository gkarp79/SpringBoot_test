package com.boot.chapter05.persistence;

import com.boot.chapter05.domain.Board;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DynimicBoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

}
