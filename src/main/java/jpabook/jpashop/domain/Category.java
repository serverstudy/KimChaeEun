package jpabook.jpashop.domain;

import jpabook.jpashop.domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany // 카테고리-상품은 다대다 관계
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")) //카테고리-상품 다대다 관계를 풀기위해 중간 테이블 category_item 필요
    private List<Item> items = new ArrayList<>();

    /**셀프로 연관관계 */
    @ManyToOne(fetch = LAZY)  //자신-부모 는 다대일 관계, 부모가 관계의 주인
    @JoinColumn(name = "parent_id")
    private Category parent; //카테고리가 계층구조니까 부모랑 자식 표현할때 자기자신임
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL) //자신-자식 은 일대다 관계, 부모가 fk 니까 관계의 주인이고, 얘는 parent 필드에 매핑
    private List<Category> child = new ArrayList<>();


    //==연관관계 메서드==//
    //category-child (주인x)
    public void addChildCategory(Category child) {
        //부모, 자식 카테고리에 양쪽에 들어가야한다.
        this.child.add(child); //나
        child.setParent(this);//너
    }
}




