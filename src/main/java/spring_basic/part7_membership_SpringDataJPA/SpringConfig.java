package spring_basic.part7_membership_SpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_basic.part7_membership_SpringDataJPA.aop.TimeTraceAop;
import spring_basic.part7_membership_SpringDataJPA.repository.MemberRepository;
import spring_basic.part7_membership_SpringDataJPA.service.MemberService;

//MemberController - MemberRepository - SpringDataJpaMemberRepository
@Configuration
public class SpringConfig {

    //스프링 데이터 JPA 객체
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
}