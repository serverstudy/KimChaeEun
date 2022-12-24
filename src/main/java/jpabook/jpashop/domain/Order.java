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


    @OneToMany(mappedBy = "order") //OrderItem의 order필드와 매핑 - 연관관계의 주인이 아님!
    private List<OrderItem> orderItems = new ArrayList<>(); //주문 상품 목록

    @OneToOne(fetch = LAZY) //order과 delivery는 일대일 관계, 관게의 주인!
    @JoinColumn(name = "delivery_id") //FK이름
    private Delivery delivery; //배송정보


    private LocalDateTime orderDate; //주문 시간 - 시간, 분


    @Enumerated(EnumType.STRING) //enum 타입 사용
    private OrderStatus status; // 주문 상태 - ORDER, CANCEL enum타입(열거형)클래스 만들기

}
