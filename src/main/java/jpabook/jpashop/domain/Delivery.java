package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY) // 배송과 주문은 일대일 관계, 관께의 주인이 아님. order의 delivery필드와 매핑
    private Order order;

    @Embedded //내장타입 사용
    private Address address;

    @Enumerated(EnumType.STRING) // enum 타입 사용시 반드시 추가 - EnumType.ORDINAL(숫자) or EnumType.STRING(문자열)사용
    private DeliveryStatus status; // enum으로 READY, COMP
}
