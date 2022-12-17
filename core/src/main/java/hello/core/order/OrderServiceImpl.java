package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회한 뒤
        int discountPrice = discountPolicy.discount(member, itemPrice); //해당 회원 할인가격 받기
        // SRP 잘 지켜진 것. order입장에선 discountpolicy 몰라도 그냥 받아쓰면 됨

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종생성된 주문 반환
    }
}
