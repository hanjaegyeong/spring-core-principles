package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//스프링 부트로 생성 시 CoreApplication파일(루트폴더) 내부 애노테이션이 @ComponentScan 갖고 있으므로 따로 만들어줄 필요 없음
@Configuration
@ComponentScan(
        basePackages = "hello.core.member", //탐색할 시작 위치 지정(전체파일 탐색 안하고 해당 파일의 하위패키지만 탐색)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)) //탐색 제외대상 지정
public class AutoAppConfig {
}
