package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //0) jpa 엔티티
@Getter @Setter //4) 게터 세터 롬복으로 생성
public class Member {
    @Id @GeneratedValue //2) 식별자를 매핑한다, 자동생성되게한다 -> primary key 자동생성한다는 의미같음
    private Long id; //1) 이거 먼저 치고나서 위에 식별자로 @Id, 자동생성되는 @GeneratedValue 입력
    private  String username; //3) 속성 하나더 추가

}
