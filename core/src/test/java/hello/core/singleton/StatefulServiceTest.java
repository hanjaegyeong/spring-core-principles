package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        int AuserAPrice = statefulService1.order("userA", 10000); //ThreadA: A사용자 10000원 주문
        int AuserBPrice =statefulService2.order("userB", 20000); //ThreadB: 중간에 끼어든 B사용자 20000원 주문
        //즉 StatefulService라는 "동일 객체"(싱글톤)에 price(공유되는 필드)가 20000원으로 대체 된 것

//        int price = statefulService1.getPrice(); //ThreadA: 사용자A 주문 금액 조회
        System.out.println("price = " + AuserAPrice); //ThreadA: 사용자A는 10000원을 기대했지만, but 20000원 출력
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}