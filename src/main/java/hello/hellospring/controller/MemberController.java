package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// @Controller 어노테이션을 넣으면 스프링 부트가 작동할 때, @Controller 어노테이션이 적용되어 있는 클래스를
// 자동으로 스프링 컨테이너 안에 넣어준다.
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
