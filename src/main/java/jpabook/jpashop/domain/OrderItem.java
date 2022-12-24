package jpabook.jpashop.domain;

import jpabook.jpashop.domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private long id;

    @ManyToOne(fetch = LAZY)  // 주문상품-상품은 다대일 관계
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)  // 주문상품-주문은 다대일 관계, 연관 관계의 주인!
    @JoinColumn(name = "order_id") //Order의 order_id가 FK
    private Order order;
    private int orderPrice; //주문 당시 가격
    private int count; // 주문 당시 수량


}

