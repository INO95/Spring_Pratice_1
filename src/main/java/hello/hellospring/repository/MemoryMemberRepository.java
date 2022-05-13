package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 구현체
//어노테이션 설정을 통해 스프링에 인식시킨다.
//@Repository
public class MemoryMemberRepository implements MemberRepository{

    // 저장
    private static Map<Long, Member> store = new HashMap<>();
    // 0, 1, 2 key값을 생성해준다
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // 먼저 id값을 세팅해준다.
        member.setId(++sequence);
        // 스토어에 저장
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null값을 반환하는 것을 방지하기 위해 Optional 사용
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 람다를 사용, 맵을 돌면서 루프를 돌린다.
        return store.values().stream()
                // 이름이 같은 경우를 찾으면 필터링이 된다.
                .filter(member -> member.getName().equals(name))
                // 끝까지 돌렸는데 없으면 Optinal에 null이 포함되서 반환된다.
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // 실무에선 List를 많이 쓴다고 함
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        // store를 클린해준다.
        store.clear();
    }
}
