package jpa.domain;

import javax.persistence.*;

@Entity
/**
 * 조인전략
 * - @DiscriminatorColumn 없어도 되고 있어도 됨.
 * - 정석 전략.
 *
 * 장점
 * - 테이블이 정규화됨.
 * - 저장공간효율화
 * - 외래 키 참조 무결성 제약조건 활용가능
 * 단점
 * - 조회 시 조인을 많이 사용, 성능 저하 ( 막 저하되지 않음.)
 * - 조회 쿼리가 복잡함
 * - 데이터 저장시 insert sql 2번 호출
 */
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "DIS_TYPE")
/**
 * 단일테이블 전략
 * - dtype은 무조건 있어야함.(@DiscriminatorColumn)
 *
 * 장점
 * - 조인이 필요 없으므로 일반적으로 조회 성능이 빠름
 * - 조회 쿼리가 단순함.
 * 단점
 * - 자식 엔티티가 매핑한 컬럼은 모두 null 허용
 * - 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있는 상황에 따라서 조회 성능이 오히려 안좋아질 수 있다.
 */
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "DIS_TYPE")
/**
 * 구현 클래스마다 테이블 전략
 * - @DiscriminatorColumn 필요없음.
 * - item 테이블이 없음.
 * - 사용하면 안됨.
 *
 * 장점
 * - 서브타입을 명확하게 구분해서 처리할 때 효과적
 * - not null 제약조건 사용 가능
 * 단점
 * - 여러 자식 테이블을 함께 조회할 때 성능이 느림
 * - 자식 테이블을 통합해서 쿼리하기 어려움
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
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

    public Item() {
    }

    public Item(String name, Integer stockQuantity) {
        this.name = name;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
