package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
public class JpaMemberRepository implements MemberRepository {

    // 스프링부트가 엔티티매니저 알아서 만들어줌
    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    public Member save(Member member) {
        // persist : 영속적인, 영구적인 그런 의미
        // 이렇게하면 jpa가 insert문 알아서 만들어준다.
        em.persist(member);
        return member;
    }
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    // pk 기반이 아닌 조회 기능은 jpql을 작성해야함
    public Optional<Member> findByName(String name) {
        // 객체(entity)를 대상으로 쿼리를 날림
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}