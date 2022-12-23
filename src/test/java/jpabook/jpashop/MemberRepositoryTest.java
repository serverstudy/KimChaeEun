package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class) // JUnit에게 스프링 관련 테스트를 할거야. 라고 알리기
@SpringBootTest // 스프링 부트로 테스트한다.
public class MemberRepositoryTest {
    // 멤버리포지토리 잘되는지 테스트하기

    @Autowired
    MemberRepository memberRepository; // Autowired로 MemberRepository를 인젝션받기

    //라이브템플릿에서 tdd치면 아래 틀나오게 만들어놨음
    @Test
    @Transactional // 엔티티 매니저를 위해 트랜잭션 꼭 필요
    @Rollback(false) // 이거 안쓰면 기본적으로 스프링에서는 테스트 후 db관련 작업을 rollback해서 db를 봐도 변화가 없다.
    public void testMember() throws Exception {
        //given - 멤버 하나 만들어서, 이름 설정 후 잘 저장되는지 확인하자
        Member member =  new Member();
        member.setUsername("memberA");

        //when - 멤버 저장 후, id 뽑아와서
        Long savedId = memberRepository.save(member); // 컨트롤+알트+V누르면 자동으로 Long 변수에 extract된 id가져옴
        Member findMember = memberRepository.find(savedId); // save한게 잘 저장된건지 찾기

        //then - 검증 : 멤버 객체 id,username랑 레포지토리의 멤버 id, username가 같은지 검증
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());


        Assertions.assertThat(findMember).isEqualTo(member); // true = id값이 같으면 같은 엔티티로 인식함.
    }
}