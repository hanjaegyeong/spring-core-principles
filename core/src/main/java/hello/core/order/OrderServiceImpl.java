package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ; //추상화에만 의존하도록
    private final DiscountPolicy discountPolicy; //추상화에만 의존하도록

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) { 
        //스프링 빈 중복조회문제를 Autowired에 파라미터명 매칭으로 해결: rateDiscountPolicy 명시
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회한 뒤
        int discountPrice = discountPolicy.discount(member, itemPrice); //해당 회원 할인가격 받기
        // SRP 잘 지켜진 것. order입장에선 discountpolicy 몰라도 그냥 받아쓰면 됨

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종생성된 주문 반환
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
