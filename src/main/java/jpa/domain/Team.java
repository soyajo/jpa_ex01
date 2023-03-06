package jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    /**
     * mappedBy
     * - 값을 넣어도 디비에 안들어감.
     * - 연관관계의 주인은 fk가 있는 객체가 주인!!!
     * - Member.team이 주인이다.
     */
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<Member> getMembers() {
        return members;
    }

    /**
     * 연관관계 편의 메소드
     * @param member
     */
    public void addMember(Member member) {
        this.getMembers().add(member);
        member.setTeam(this);
    }


}
