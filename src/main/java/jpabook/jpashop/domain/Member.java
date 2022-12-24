package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //0) jpa 엔티티
@Getter @Setter //4) 게터 세터 롬복으로 생성
public class Member {
    @Id @GeneratedValue //2) 식별자를 매핑한다, 자동생성되게한다 -> primary key 자동생성한다는 의미같음
    @Column(name = "member_id") //member_id로 이름 매핑
    private Long id; //1) 이거 먼저 치고나서 위에 식별자로 @Id, 자동생성되는 @GeneratedValue 입력
    private  String username; //3) 속성 하나더 추가

    @Embedded //내장 타입 사용 - @Embeddable이랑 이거랑 둘중 하나만 쓰면되는데 둘다 쓰겠다.
    private Address address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)//member와 order는 일대다 관계(중요) - FK
    // Order테이블에 있는 member필드에 매핑된다 = 연관관계의 주인이 아님!
    private List<Order> orders = new ArrayList<>();

}
