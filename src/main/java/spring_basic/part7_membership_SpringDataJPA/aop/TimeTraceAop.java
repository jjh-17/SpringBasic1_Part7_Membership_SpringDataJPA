package spring_basic.part7_membership_SpringDataJPA.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
[Aspect Oriented Programming - AOP]
-모든 메서드의 동작 시간을 측정하고자 할 때 활용
-공통 관심 사항(cross-cutting concern)과 핵심 관심 사항(core concern)을 분리
    ==> 공통 관심 사항 - 시간 측정 로직 ==> 아래 클래스
        핵심 관심 사항 - 회원가입, 회원 조회 등등

AOP 이전 : MemberController -> MemberService -> MemberRepository
AOP 이후 : 프록시 MemberController ->  MemberController
            -> 프록시 MemberService ->  MemberService
            -> 프록시 MemberRepository ->  MemberRepository
 */

//@Component //빈에 직접 등록을 하지 않을 경우, @Component 추가
@Aspect
public class TimeTraceAop {
//    //빈에 직접 등록을 하지 않을 경우, 아래 주석 사용
//    spring_basic.part7_membership_SpringDataJPA 패키지 내 모든 메서드에 적용
//    @Around("execution(* spring_basic.part7_membership_SpringDataJPA..*(..)) ")

    //SpringConfig를 제외한 spring_basic.part7_membership_SpringDataJPA 패키지 내 모든 클래스에 적용
    //예외 미적용 시 SpringConfig의 timeTraceAop 메서드도 AOP로 처리 ==> 자기 자신을 생성하는 코드를 AOP로 처리 ==> 순환참조 발생
    @Around("execution(* spring_basic.part7_membership_SpringDataJPA..*(..)) " +
            "&& !target(spring_basic.part7_membership_SpringDataJPA.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try{
            return joinPoint.proceed(); //다음 메서드로 진행한다.
        } finally {
            long finish = System.currentTimeMillis();
            System.out.println("END : " + joinPoint + " " + (finish-start) + "ms");
        }
    }
}
