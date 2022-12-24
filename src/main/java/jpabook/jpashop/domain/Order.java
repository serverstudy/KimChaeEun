package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "orders") //이거 안해주면 이름 Order로 쓰게돼서 orders로 테이블 매핑
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id") //주요키 이름 order_id로 매핑
    private Long id;

    @ManyToOne(fetch = LAZY) //order과 member는 다대일 관계 (중요) - FK, 연관관계의 주인!!!
    @JoinColumn(name = "member_id") // FK이름
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) //OrderItem의 order필드와 매핑 - 연관관계의 주인이 아님!
    private List<OrderItem> orderItems = new ArrayList<>(); //주문 상품 목록

    @OneToOne(cascade = CascadeType.ALL, fetch = LAZY) //order과 delivery는 일대일 관계, 관게의 주인!
    @JoinColumn(name = "delivery_id") //FK이름
    private Delivery delivery; //배송정보

    private LocalDateTime orderDate; //주문 시간 - 시간, 분

    @Enumerated(EnumType.STRING) //enum 타입 사용
    private OrderStatus status; // 주문 상태 - ORDER, CANCEL enum타입(열거형)클래스 만들기

    //==연관관계 메서드==//
    // order랑 member 연관관계 (주인o)
    public void setMember(Member member) { // 주문을 하면 = Order의 member에 이 사람을 넣고, Member의 orders 리스트를 가져와서 -> 이 주문을 리스트에 추가
        this.member = member;
        member.getOrders().add(this); //저쪽이 List<Order>라서
    }

    // order랑 orderItems도 양방향관계니까 (주인x)
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    // order랑 delivery 양방향 (주인o)
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this); // 저쪽에 그냥 private Order타입이라서
    }
}
