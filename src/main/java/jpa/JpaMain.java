package jpa;


import jpa.domain.Member;
import jpa.domain.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");


        EntityManager em = emf.createEntityManager();
        // 트렌젝션 생성
        EntityTransaction ts = em.getTransaction();
        // 트렌젝션 시작
        ts.begin();

        try {

            /**
             * 영속성 컨테스트
             * 1차 캐시로 둠
             */
            // 비영속
//            Member member = new Member();
//            member.setName("HelloA");
//
//            // 영속
//            em.persist(member);
//
//            // 준영속(영속성 컨테이너에 분리, 준영속 상태)
//            em.detach(member);
//
//            // 영속성 초기화 후 디비에 들어가짐
//            em.flush();
//
//            // 영속성 삭제
//            em.remove(member);
//
//            // 영속성 초기화 후 디비에 들어가짐
//            ts.commit();

            /**
             * 영속성 보장
             */
//            Member findMember1 = em.find(Member.class, 10L);
//            Member findMember2 = em.find(Member.class, 10L);
//
//            // 동일성 비교 true
//            System.out.println("result = " + (findMember1 == findMember2));
            /**
             * 쓰기 지연
             */

//            Member memberA = new Member("memberA");
//            Member memberB = new Member("memberB");
//
//            em.persist(memberA);
//            em.persist(memberB);
//
//            Member findMember = em.find(Member.class, memberA.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            // 여기까지 db에 데이터를 보내지 않음
//
//            ts.commit();
//
//            // 여기서 부터 db에 데이터를 select
//            System.out.println("findMember.getName() = " + findMember.getName());

            /**
             * 변경 감지
             * dirty checking
             *
             */
//            Member member = new Member("memberA");
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//
//            member.setName("memberB");
//
//            ts.commit();
//            System.out.println("findMember = " + findMember);

            /**
             * 플러시
             * em.flush()
             * 영속성 컨테이너의 변경사항을 db에 반영
             * ts.commit() - 자동호출
             * jpql 쿼리 실행 - 자동호출
             * em.flush() - 수동호출
             */
//            Member member = new Member("memberA");
//
//            em.persist(member);
//
//            // 여기서 insert
//            em.flush();
//
//            System.out.println("===================");
//
//            // select 문은 안나감 (영속성 컨테이너에서 가지고옴)
//            Member findMember1 = em.find(Member.class, member.getId());
//
//            // select
//            // Long 타입이라 L 붙여야함. (안하면 에러)
//            // id 가 존재하지 않으면 에러
//            Member findMember2 = em.find(Member.class, 7L);
//
//            System.out.println("findMembe2 = " + findMember2);
//
//            // update
//            findMember2.setName("memberC");
//            ts.commit();
            /**
             * 준영속 상태
             * 영속 -> 준영속
             *
             */
            // 영속
//            Member member = em.find(Member.class, 18L);
//            member.setName("AAAA");
//
//            // 준영속 상태
//            // 업데이트가 안됨.
//            em.detach(member);
//            em.clear();
//
//            // 업데이트 됨.
//            Member member1 = em.find(Member.class, 18L);
//            member1.setName("BBBB");
//
//            System.out.println("===============");
//            ts.commit();


            /**
             * @GeneratedValue(strategy = GenerationType.IDENTITY) 전략
             * em.persist(member); 이 때 insert 문 실행
             */
//            Member member = new Member("memberA",10, RoleType.ADMIN,new Date(),new Date(),LocalDate.now(), LocalDateTime.now(),"description1","code");
//            System.out.println("===============");
//            em.persist(member);
//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("===============");
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember = " + findMember);
//
//            ts.commit();

            /**
             * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
             *
             */
//            Member member = new Member("memberA",10, RoleType.ADMIN,new Date(),new Date(),LocalDate.now(), LocalDateTime.now(),"description1","code");
//            System.out.println("===============");
//            // 시퀀스 생성
//            em.persist(member);
//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("===============");
//
//            // allocationSize = 50 설정하면 실행 시 1 부터 시작, 두 번째 실행 시 51 부터 시작
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember = " + findMember);
//            //insert
//            ts.commit();


        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }

        em.close();

        emf.close();

    }
}
