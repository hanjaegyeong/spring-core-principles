package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//스프링 부트로 생성 시 CoreApplication파일(루트폴더) 내부 애노테이션이 @ComponentScan 갖고 있으므로 따로 만들어줄 필요 없음
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)) //탐색 제외대상 지정
public class AutoAppConfig {
}
