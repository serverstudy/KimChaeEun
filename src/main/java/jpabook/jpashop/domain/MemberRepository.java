package jpabook.jpashop.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository // 1) 레포지토리 지정
public class MemberRepository {
    @PersistenceContext //2) 엔티티 만들었으니까, 엔티티 매니저가 필요하다. 이거 쓰면 엔티티 매니저를 스프링 부트가 주입해준다.
    private EntityManager em; // 3) dependencies의 spring-data-jpa가 엔티티 매니저 생성을 알아서 해준다.

    public Long save(Member member) { // 5) 회원 저장
        em.persist(member);
        return member.getId(); // 6) 회원 id정도 반환함
    }

    public Member find(Long id) { //7) id로 회원 조회
        return em.find(Member.class, id);
    }
}
