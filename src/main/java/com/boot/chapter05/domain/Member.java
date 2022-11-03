package com.boot.chapter05.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "boardList")
public class Member {

    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String password;
    private String name;
    private String role;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Board> boardList = new ArrayList<Board>();

}