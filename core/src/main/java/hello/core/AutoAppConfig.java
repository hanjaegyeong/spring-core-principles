package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// excludeFilters: 컴포넌트 스캔 제외대상 지정, 기존에 만든 config클래스들 제외 : @Configuration도 내부에 @ComponentScan이 있어서 컴포넌트 스캔되니 제외
// 컴포넌트 스캔은 @ComponentScan이 붙은 클래스를 스캔해 스프링 빈으로 자동 등록해줌
// 사용하는 구현체들에 @Component 붙여줌 (serviceimpl, orderImpl, ratediscount, memoryrepository)
// config파일에서 의존관계 주입 안해주니 구현체들 내부에서 @Autowired
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
}
