package jpabook.jpashop.domain.Item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item { //상품은 추상클래스로 만든다 - Album, Book, Movie와 상속관계
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items") // 상품-카테고리는 다대다 관계, 관계의 주인이아님. item의 items필드와 매핑
    private List<Category> categories = new ArrayList<>();
    
}
