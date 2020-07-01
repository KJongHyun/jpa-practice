package com.jonghyeon.jpapractice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String userName;


    @ManyToOne
    Team team;
}
