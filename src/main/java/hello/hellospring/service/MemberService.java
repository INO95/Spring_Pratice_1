package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//컨트롤 쉬프트 t : 테스트 만들기
public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    //알트 + 인서트 생성자, 게터세터 뽑기


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    회원가입
     */

    public Long join(Member member) {
        // 같은 이름이 있는 회원 중복 ㄴㄴ
        // 컨트롤 알트 v : 리턴 걍 해줌 개꿀
        //Optional<Member> result = memberRepository.findByName(member.getName());
        //옵셔널로 감쌌기 때문에 여기서 다양한 메서드를 사용할 수 있다.
        //만약 값이 있으면 실행
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
//        memberRepository.save(member);
//        return member.getId();

// 컨트롤 알트 쉬프트 t - extra method 누르면 메서드 만듬


        validateDuplicateMember(member);//중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 위 코드를 정리하면?
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */

    // 서비스는 비즈니스에 의존적으로 설계한다 (이름 등 )
    // 반면 리포지토리는 좀더 기계적인 느낌
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
