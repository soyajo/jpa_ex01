package jpa.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 공통 매핑
 * - 공통 매핑 정보가 필요할 때 사용 (id, name)
 * - 상속관계 매핑 x
 * - 엔티티 x , 테이블과 매핑 x
 * - 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
 * - 조회, 검색 불가(em.find(BaseEntity) 불가)
 * - 직접 생성해서 사용할 일이 없으므로 추상 클래스 권장
 */
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "INSERT_USERNAME")
    private String createdBy;
    @Column(name = "INSERT_DATE")
    private LocalDateTime createdDate;
    @Column(name = "UPDATE_USERNAME")
    private String lastModifiedBy;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
