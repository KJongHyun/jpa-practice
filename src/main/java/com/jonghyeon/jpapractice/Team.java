package com.jonghyeon.jpapractice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Team {
    @Id @GeneratedValue
    private Long Id;

    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();


    public void addMember(Member member) {
        member.setTeam(this);
        this.members.add(member);
    }
}
