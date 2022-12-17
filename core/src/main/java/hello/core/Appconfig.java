package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//config클래스는 생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해 주입해준다
public class Appconfig {

    //역할과 구현 분리
    public MemberService memberService() { //역할
        return new MemberServiceImpl(memberRepository()); //여기서 레포지토리 변경 안해도 됨
    }

    private static MemberRepository memberRepository() { //구현
        return new MemoryMemberRepository(); //이제 레포지토리 변경 시 이 부분만 변경하면 됨
    }

    public OrderService orderService() { //역할
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //여기서 레포지토리 변경 안해도 됨
    }

    public DiscountPolicy discountPolicy() { //구현
        return new FixDiscountPolicy();
    }
}
