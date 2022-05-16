package hello.hellospring;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {

    //    오토와이어드 없이 직접 자바 코드로 스프링에 등록하기
    //    @Bean
    //    public MemberService memberService() {
    //        return new MemberService(memberRepository());
    //    }
    //
    //    @Bean
    //    public MemberRepository memberRepository() {
    //        return new MemoryMemberRepository();
    //    }
//    private final DataSource dataSource;
//    private final EntityManager em;
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    //}
}