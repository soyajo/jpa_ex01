package jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    /**
     * 영속성 전이
     * - cascade = CascadeType.ALL
     * 고아객체
     * - 부모 엔티티와 연관관계가 끊어진 자식 엔티티를 자동으로 삭제하는 기능
     * - orphanRemoval = true
     */
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child) {
        this.childList.add(child);
        child.setParent(this);
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
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
}
