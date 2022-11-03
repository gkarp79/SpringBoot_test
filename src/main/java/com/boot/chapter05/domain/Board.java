package com.boot.chapter05.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@ToString(exclude = "boardList")
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
//    private String writer;
    private String content;
    private Date createDate;
    private Long cnt;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID", nullable = false)
    private Member member;

    public void setMember(Member member){
        this.member = member;
        member.getBoardList().add(this);
    }
}