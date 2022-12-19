package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicataionContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //ac.getBeanDefinitionNames(): 스프링에 등록된 모든 빈이름 조회->문자열배열로 반환
        for (String beanDefinitionName : beanDefinitionNames) { //모든 빈 for문
            Object bean = ac.getBean(beanDefinitionName);  //ac.getBean(빈이름): 빈이름으로 빈 객체 조회
            System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
        }
    }
    
    //스프링이 등록한 빈이 아니라 내가 등록한 빈들만 출력
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION: 내가 등록한 애플리케이션 빈
            //ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈(자동등록되는)
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
                
            }
        }
    }
}
