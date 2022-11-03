package com.boot.chapter05.persistence;

import com.boot.chapter05.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
