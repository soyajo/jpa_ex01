package jpa.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 엔티티 매핑
 */

@Entity
@Table()
/**
 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator") 전략
 * 오라클 기본키 전략
 * 시퀀스 object 생성
 * SequenceGenerator
 *
 *  initialValue
 *  - 시퀀스 ddl을 생성할 때 처음 1 시작하는 수를 지정
 *  allocationSize
 *  - 시퀀스 한 번 호출에 증가하는 수(성능 최적화에 사용, db 시퀀스 값이 하나씩 증가하도록 설정되어 있으면 이 값을 반드시 1로 성정해야함.)
 *  - 디비에 미리 50 시퀀스 올려놓고 사용
 *
 */
//@SequenceGenerator(
//        name = "member_seq_generator",
//        sequenceName = "member_seq",
//        initialValue = 1,
//        allocationSize = 50
//)
/**
 * @GeneratedValue(strategy = GenerationType.TABLE) 전략
 *
 */
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ",
//        allocationSize = 1
//)
public class Member extends BaseEntity {

    /**
     * 기본키 매핑
     * strategy = GenerationType.AUTO - 기본
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * autoIncrement 개념과 동일
     * 기본키생성을 db에 위임
     * em.persist() 시점에 바로 insert 쿼리 적용!!! (중요)
     */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 오라클 기본키 전략
     * 시퀀스 object 생성
     */
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    /**
     * 키 생성 전용 테이블을 하나 만들어서 데이터베이스 시퀀스를 흉내내는 전략
     * 장점 : 모든 데이터베이스에 적용 가능
     * 단점 : 성능
     */
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
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
     * 연관관계의 주인
     * FetchType.LAZY - 지연로딩
     *
     */
    /**
     * 지연로딩
     * - team 을 가지고 올때 프록시 객체로 가지고옴.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    /**
     * 즉시로딩
     * - 프록시 객체를 사용하지 않고 바로 가지고옴.
     *
     */
//    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;


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
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
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

    /**
     * 임베디드 타입과 테이블 매핑
     */
    // 기간 Period
    @Embedded
    private Period period;

    // 주소
    @Embedded
    private Address homeAddress;

    @Embedded
    /**
     * @AttributeOverrides
     * - 한 엔티티에서 같은 값 타입을 사용한다면?
     * - 컬럼 명이 중복됨
     * - @AttributeOverrides, @AttributeOverride 을 사용해서 컬럼 명 속성을 재정의
     *
     */
    @AttributeOverrides({
            @AttributeOverride(name="city",
                    column=@Column(name = "WORK_CITY")),
            @AttributeOverride(name="street",
                    column=@Column(name = "WORK_STREET")),
            @AttributeOverride(name="zipcode",
                    column=@Column(name = "WORK_ZIPCODE"))

    })
    private Address workAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public Member(String name, Integer age, RoleType roleType, LocalDate testLocalDate, LocalDateTime localDateTime, String description, String code) {
        this.name = name;
        this.age = age;
        this.roleType = roleType;
//        this.createdDate = createdDate;
//        this.lastModifiedDate = lastModifiedDate;
        this.testLocalDate = testLocalDate;
        this.localDateTime = localDateTime;
        this.description = description;
        this.code = code;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
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

//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", roleType=" + roleType +
//                ", description='" + description + '\'' +
//                ", code='" + code + '\'' +
//                '}';
//    }

    public Member() {
    }


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

    public LocalDate getTestLocalDate() {
        return testLocalDate;
    }

    public void setTestLocalDate(LocalDate testLocalDate) {
        this.testLocalDate = testLocalDate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        // 연관관계 편의 메소드
        team.getMembers().add(this);
    }

}
