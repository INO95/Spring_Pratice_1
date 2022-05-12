package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

// 굳이 public으로 안 해도 된다.
// 테스트 케이스의 장점 : 여러가지 기능을 같이 돌릴 수 있다.
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트는 순서, 의존관계 상관 없이 테스트가 되어야 한다.
    // 그래서 하나의 테스트가 끝날 때 마다 공용 데이터를 지워줘야한다.
    // 메서드가 실행이 끝날 때마다 동작하는 콜백 메서드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    //@Test 어노테이션을 이용해서 메서드를 실행해볼 수 있다.
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // 반환 타입이 Optional일 때는 get으로 꺼낼 수 있다.
        Member result = repository.findById(member.getId()).get();

        // soutv 커맨드 기억
        // 이런 방법도 있지만
        // System.out.println("result = " + (result == member));

        // JUnit, 파라미터는 (기대값, 비교값) 순서햇갈림
        //Assertions.assertEquals(member, result);

        // Assertj, 이게짱임
        // 커서 대고 알트 엔터, 스태틱 임포트하면 이렇게 구조분해가 됨
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        // 꿀팁 : 쉬프트 f6 누르면 변수명 일괄변경 가능
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
