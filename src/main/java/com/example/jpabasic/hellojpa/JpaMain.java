package com.example.jpabasic.hellojpa;

import com.example.jpabasic.hellojpa.domain.oneline.Member2;
import com.example.jpabasic.hellojpa.domain.oneline.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("team1");
            em.persist(team);

            Member2 member2 = new Member2();
            member2.setUsername("member2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();

            Member2 member21 = em.find(Member2.class, member2.getId());
            System.out.println(member21.getTeam().getName());

            Team team1 = em.find(Team.class, team.getId());
            System.out.println("==============");
//            for(Member2 m : team1.getMembers()){
//                System.out.println("m = " + m.getUsername());
//            }
            team1.getMembers().stream()
                    .map(i->"m = " + i.getUsername())
                    .forEach(System.out::println);


        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
