package jpa.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 엔티티 매핑
 *
 */

@Entity
@Table()
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * unique - @Table 옵션에 사용함으로 잘 사용 안함.
     * length - 길이 조절
     * nullable - 널허용여부
     * insertable - insert 여부
     * updatable - update 여부
     * columnDefinition - 컬럼 조건 지정 (문자로) 예)  columnDefinition = "varchar(100) default 'EMPTY"
     */
    @Column(length = 100, nullable = false)
    private String name;

    private Integer age;

    /**
     * EnumType.STRING - string 그대로 들어감.
     * EnumType.ORDINAL - 순서대로 숫자로 변경해서 들어감.
     * - ORDINAL 보단 STRING 을 사용하는게 좋다. (순서가 변경되면 큰일..)
     * STRING - 거의 필수
     */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    /**
     * 요즘에는 localDate 나 localDateTime 을 사용함.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    private LocalDate testLocalDate;
    private LocalDateTime localDateTime;
    /**
     * 대형 문자열일 때 사용
     */
    @Lob
    private String description;

    /**
     * 디비컬럼과 무관한 필드
     */
    @Transient
    private String code;

    public Member(String name, Integer age, RoleType roleType, Date createdDate, Date lastModifiedDate, String description) {
        this.name = name;
        this.age = age;
        this.roleType = roleType;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", roleType=" + roleType +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Member() {}



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
}
