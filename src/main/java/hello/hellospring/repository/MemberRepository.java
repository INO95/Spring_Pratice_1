package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원을 저장하면 저장된 회원이 반환됨
    Member save(Member member);
    // id로 회원을 찾음
    Optional<Member> findById(Long id);
    // 이름으로 회원을 찾음
    Optional<Member> findByName(String name);
    // 지금까지 저장된 모든 회원 리스트를 반환
    List<Member> findAll();
}
