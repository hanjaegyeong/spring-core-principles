package hello.core;

import hello.core.member.Member;
import hello.core.member.Grade;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//순수한 자바코드로만 개발한 것
public class MemberApp {
    public static void main(String[] args) {
//        Appconfig appConfig = new Appconfig();
//        MemberService memberService = appConfig.memberService(); //이제 memberService, orderService는 config클래스를 통해 받아야 함

        //ApplicationContext가 모든 객체를 관리해주는 스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //Appconfig의 구성정보를 갖고 스프링 컨테이너에 넣어서 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// 컨테이너에서 꺼낼 매서드명, 반환타입 인자로

        Member member = new Member(1L, "memberA", Grade.VIP); //enum클래스(열거형)은 바로 사용
        memberService.join(member); //멤버를 서비스에 회원가입

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
