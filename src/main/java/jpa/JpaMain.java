package jpa;


import jpa.domain.*;

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

            /**
             * 단방향 연관관계
             *
             */
//            Team team = new Team("teamA");
//            em.persist(team);
//            Member member = new Member("memberA",10, RoleType.ADMIN,new Date(),new Date(),LocalDate.now(), LocalDateTime.now(),"description1","code");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember = " + findMember);
//
//            ts.commit();
            /**
             * 양반향 연관관계 - 실패 예.
             * - 주의사항!!!
             */
//            Member member = new Member("memberA",10, RoleType.ADMIN,new Date(),new Date(),LocalDate.now(), LocalDateTime.now(),"description1","code");
//
//            Team team = new Team("teamA");
//            // 연관관계의 주인이 member.setTeam() 이라 member.team_id 에 값이 안들어가진다.
//            team.getMembers().add(member);
//            em.persist(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            // null
//            System.out.println("findMember.getTeam() = " + findMember.getTeam());
//
//            ts.commit();
            /**
             * 양방향 연관관계 - 올바른 예.
             * - 단방향 매핑만으로 이미 연관관계 매핑은 완료 (중요)
             * - 단방향 매핑을 잘 하고 양방향은 필요할 때 추가하기.
             * - jpql에서 역방향으로 탐색할 일이 많음.
             * - 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자.
             * - 연관관계 편의 메소드를 생성하자.
             * - 양방향 연관관계 셋팅할 때는 둘다 셋팅해야한다.
             *
             * 연관관계의 주인을 정하는 기준
             * - fk 위치로 기준으로 정함.
             *
             * 주의사항
             * - 양방향 매핑시에 무한 루프를 조심하자
             * - 예 ) toString(), lombok, JSON 생성 라이브러리
             * 해결
             * - 롬북 toString - 사용 x
             * - 컨트롤러에 entity를 반환하지말라.
             * - DTO로 변환해서 반환한다.
             */
//            Team team = new Team("teamA");
//            em.persist(team);
//
//            Member member = new Member("memberA",10, RoleType.ADMIN,new Date(),new Date(),LocalDate.now(), LocalDateTime.now(),"description1","code");
//            // 연관관계 편의 메소드 (2방법)
//            member.changeTeam(team);
////            team.addMember(member);
//
//            // 이걸 합쳐야한다. (연관관계 편의 메소드)
////            member.setTeam(team);
////            team.getMembers().add(member);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            // null
//            System.out.println("findMember.getTeam() = " + findMember.getTeam());
//
//            ts.commit();

            /**
             * 연관관계 매핑 시작
             *
             */
//            Order order = new Order("order1",LocalDate.now());
//            em.persist(order);
//
//            OrderItem orderItem = new OrderItem(1000, 2);
//            em.persist(orderItem);
//
//            order.addOrderItem(orderItem);
//
//            em.flush();
//            em.clear();
//
//            Order findOrder = em.find(Order.class, order.getId());
//            OrderItem findOrderItem = em.find(OrderItem.class, orderItem.getId());
//            System.out.println("findOrder = " + findOrder);
//            System.out.println("findOrderItem = " + findOrderItem);
//
//            ts.commit();

            /**
             *
             * 연관관계 매핑 시 고려사항
             * - 다중성
             * - 단방향, 양뱡향
             * - 연관관계 주인
             *
             * 다대일 양방향 정리
             * 기본적으로 많이 사용하는 매핑
             * 거의 모든 로직을 다대일로 하는게 좋음
             *
             * 일대다 단방향 정리
             * 외래 키가 다른 테이블에 있어 db 매핑 시 헷갈림
             * 이것보단 다대일 양방향을 쓰도록 하자. 끝
             *
             * 일대다 양방향 정리 - 쓰지말기.
             * @JoinColumn(insertable=false, updatable=false) - 읽기 전용으로 만듬.
             * 쓰지 않는게 제일 좋다.
             *
             * 일대일 관계
             * - 주 테이블이나 대상 테이블 중에 외래 키 선택 가능.
             * - 외래 키에 데이터베이스 유니크 제약조건 추가
             * - 다대일과 비슷.
             * - 주인테이블이 아닌 대상테이블에 외래키가 있으면 안됨. (jpa가 지원을 안함)
             *
             * 다대다 관계
             * - 사용하면 안됨.
             * - 꼭해야하겠다면 중간 엔티티,테이블을 생성해서 OneToMany, ManyToOne 으로 설계해서 만들어야한다.
             */

            /**
             * 고급 매핑
             *
             * 상속관계 매핑
             * - 관계형 데이터베이스는 상속 관계 x
             * - 객체의 상속과 구조와 DB의 슈퍼타입 서브타입 관계를 매핑
             * - 기존 코드를 고치지않고 어노테이션만 바꿔서 매
             *
             * 조인 전략
             * 장점
             * - 테이블이 정규화됨.
             * - 저장공간효율화
             * - 외래 키 참조 무결성 제약조건 활용가능
             * 단점
             * - 조회 시 조인을 많이 사용, 성능 저하 ( 막 저하되지 않음.)
             * - 조회 쿼리가 복잡함
             * - 데이터 저장시 insert sql 2번 호출
             *
             * 단일 테이블 전략
             * 장점
             * - 조인이 필요 없으므로 일반적으로 조회 성능이 빠름
             * - 조회 쿼리가 단순함.
             * 단점
             * - 자식 엔티티가 매핑한 컬럼은 모두 null 허용
             * - 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있는 상황에 따라서 조회 성능이 오히려 안좋아질 수 있다.
             *
             * 구현 클래스마다 테이블 전략
             * 장점
             * - 서브타입을 명확하게 구분해서 처리할 때 효과적
             * - not null 제약조건 사용 가능
             * 단점
             * - 여러 자식 테이블을 함께 조회할 때 성능이 느림
             * - 자식 테이블을 통합해서 쿼리하기 어려움
             *
             *
             * 실무팁!!!
             * 기본적으로 조인 전략으로 가고 단순한 상속관계 매핑이면 단일 테이블 전략으로 가는게 맞음.
             * 구현 클래스마다 테이블 전략은 절대 사용하지 않는걸로....
             *
             */
//            Movie movie = new Movie();
//            movie.setDirector("A");
//            movie.setActor("BBB");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
//
//            ts.commit();

            /**
             * @MappedSuperclass
             * - 공통 매핑 정보가 필요할 때 사용 (id, name)
             * - 상속관계 매핑 x
             * - 엔티티 x , 테이블과 매핑 x
             * - 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
             * - 조회, 검색 불가(em.find(BaseEntity) 불가)
             * - 직접 생성해서 사용할 일이 없으므로 추상 클래스 권장
             */
//            Member member = new Member();
//            member.setName("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            ts.commit();

            /**
             * 프록시 기초
             * em.getREference() : 데이터베이스 조회를 미루는 가짜 (프록시) 엔티티 객체 조회
             * - findMember.getClass()로 조회해보면 Member$HibernateProxy$TtbY4xfY 프록시 객체가 나옴.
             * - 가짜 객체
             *
             * 프록시 특징
             * - 프록시 객체는 처음 사용할 때 한 번만 초기화
             * - 프록시 객체가 초기화될 때 실제 엔티티로 바뀌는게 아님.
             * - 프록시 객체는 원본 엔티티를 상송받음, 따라서 타입 체크 시 주의해야함.( == 비교 실패, 대신 instance of 사용)
             * - 영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference()를 호출해도 실제 엔티티 반환
             * - 영속성 도움을 받을 수 없는 준영속 상태일 때, 프록시를 초기화하면 오류 발생
             */
//            Member member = em.find(Member.class, 1L);
//            printMember(member);
//            printMemberAndTeam(member);

//            Member member = new Member();
//            member.setName("hello");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            // 가짜 객체
//            System.out.println("findMember = " + findMember.getClass());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            ts.commit();
            //==================================
            // 프록시 객체는 원본 엔티티를 상송받음, 따라서 타입 체크 시 주의해야함.( == 비교 실패, 대신 instance of 사용) 예제
//            Member member1 = new Member();
//            member1.setName("m1");
//            em.persist(member1);
//            Member member2 = new Member();
//            member2.setName("m2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member1.getId());
//            System.out.println("m1.getClass() = " + m1.getClass());
//            Member m2 = em.getReference(Member.class, member2.getId());
//            System.out.println("m2.getClass() = " + m2.getClass());
//            // em.find == em.getReference 비교 시 같은 값이라도 false;
//            logic(m1, m2);
//            ts.commit();

            //=============================
            // 영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference()를 호출해도 실제 엔티티 반환 예제
//            Member member1 = new Member();
//            member1.setName("m1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//            // refMember가 먼저 선언되면 둘 다 프록시 객체, findMember 먼저 선언되면 둘 다 그냥 객체이다.
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass());
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass());
//            System.out.println("findMember == refMember : " + (findMember.getClass() == refMember.getClass()));

//            ts.commit();

            //================================
            // 영속성 도움을 받을 수 없는 준영속 상태일 때, 프록시를 초기화하면 오류 발생
//            Member member1 = new Member();
//            member1.setName("m1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//            // refMember가 먼저 선언되면 둘 다 프록시 객체, findMember 먼저 선언되면 둘 다 그냥 객체이다.
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass());
//
////            em.detach(refMember);
////            em.close();
//
//            // 에러 org.hibernate.LazyInitializationException
////            System.out.println("refMember.getName() = " + refMember.getName());
//
//            // 프록시 인스턴스의 초기화 여부 확인
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

//            ts.commit();

            /**
             * 즉시 로딩과 지연로딩
             *
             * 즉시 로딩
             * - n + 1 문제
             * - 절대 실무에서는 사용하면 안됨!!!! (중요)
             * - jpql에서 n + 1 문제를 일으킨다.
             * - @ManyToOne, @OneToOne 은 기본이 즉시로딩 -> 지연로딩으로 바꿔야함.
             * 지연 로딩
             * - 꼭 사용
             */
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            // Team$HibernateProxy$jgAluLTv 프록시 객체로 나옴
//            System.out.println("findMember.getTeam().getClass() = " + findMember.getTeam().getClass());
//
//            System.out.println("==================");
//            // 지연로딩으로 팀을 찾을 때 디비로 select 함.
//            findMember.getTeam().getName(); // 초기화
//            System.out.println("==================");

//            ts.commit();

            /**
             * 영속성 전이 : casecade
             * - 특정 엔티티를 영속 상태로 만들 때 연관된 엔티티도 함께 영속상태로 만들고 싶을 때
             * 예 : 부모 엔티티를 저장할 때 자식 엔티티도 함께 저장.
             *
             * 주의
             * - 영속성 전이는 연관관계를 매핑하는 것과 아무 관련이 없음
             * - 엔티티를 영속화할 때 연관된 엔티티도 함께 영속화하는 편리함을 제공할 뿐
             * 종류
             * all : 모두 적용
             * persist : 영속
             * remove : 삭제
             */
//            Child child1 = new Child();
//            child1.setName("c1");
//            Child child2 = new Child();
//            child2.setName("c2");
//
//            Parent parent = new Parent();
//            parent.setName("p1");
//
//            parent.addChild(child1);
//            parent.addChild(child2);
//            // cascade = CascadeType.ALL 하면 부모만 persist 해도 자식까지 들어감.
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//
//            ts.commit();



        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }

        em.close();

        emf.close();

    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 : " + (m1 instanceof Member));
        System.out.println("m2 : " + (m2 instanceof Member));
    }

//    private static void printMember(Member member) {
//        System.out.println("member = " + member.getName());
//    }
//
//    private static void printMemberAndTeam(Member member) {
//        String username = member.getName();
//        System.out.println("username = " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team = " + team);
//    }
}
