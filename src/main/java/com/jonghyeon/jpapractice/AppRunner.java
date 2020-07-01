package com.jonghyeon.jpapractice;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {



    @Override
    public void run(ApplicationArguments args) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member1 = new Member();
            member1.setUserName("member1");
            Member member2 = new Member();
            member2.setUserName("member2");

            Team team = new Team();
            team.addMember(member1);
            team.addMember(member2);

            em.persist(team);

            em.flush();
            em.clear();

            Team team1 = em.find(Team.class, team.getId());

            System.out.println("==============before==============");
            List<Member> members = team1.getMembers();

            for (Member member : members) {
                System.out.println("member.getId() = " + member.getId());
                
            }

            members.get(0).getTeam().setTeamName("UPDATE TEST");
            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            em.close();
        }
        entityManagerFactory.close();
    }
}
