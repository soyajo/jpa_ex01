package jpa;


import jpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try {
            Member member = new Member();
            member.setName("HelloA");

            em.persist(member);

            ts.commit();

        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }

        em.close();

        emf.close();

    }
}
