package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//config클래스는 생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해 주입해준다
public class Appconfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); //객체 인스턴스 생성을 통해 MemberService에서 사용할 구현체의 참조값을 넘김: 의존성 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
