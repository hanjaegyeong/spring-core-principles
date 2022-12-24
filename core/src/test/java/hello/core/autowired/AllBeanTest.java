package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

// 여러 개의 스프링 빈이 모두 필요할 때 ex) 클라이언트가 할인 종류 선택할 수 있어야 하는 경우(rateDiscountPolicy, fixDiscountPolicy)
public class AllBeanTest {
    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class); //config클래스 두 개 받음
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy"); // rate / fix 선택해서 discount()함수로 보내기
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;
        
        //AutoAppConfig.class에 있는 DiscountPolicy 주입받기위해 Autowired(생성자 1개라 생략 가능)
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap); //key: 빈 이름, value: 빈 객체
            System.out.println("policies = " + policies);
        }
        public int discount(Member member, int price, String discountCode) { //여기서 fix/rate에 따라
            DiscountPolicy discountPolicy = policyMap.get(discountCode); //해당 빈 이름(key)에 대응되는 객체(value)반환받음
            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);
            return discountPolicy.discount(member, price); //해당 discountPolicy의 discount매서드 실행->할인값 반환
        }
    }
}
