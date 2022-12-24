package hello.core.common;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

// but 서버 가동시 에러. 싱글톤에 따라 스프링 가동과 동시에 주입받아야 하는데 request 스코프빈은 생성 전이라서(실제 접속으로 고객 요청와야 생성되므로)
// -> 프로토타입 스코프로 해결 가능

// 로그를 출력하기 위한 MyLogger 클래스
@Component
@Scope(value = "request") // 리퀘스트 스코프 지정 -> 이 빈은 HTTP 요청 당 하나씩 생성되고, HTTP 요청이 끝나는 시점에 소멸
public class MyLogger {  // 웹 접속 URL 로그 띄우기.

    private String uuid; // 안겹치는 ID부여
    private String requestURL;

    public void setRequestURL(String requestURL) { //requestURL 은 이 빈이 생성되는 시점에는 알 수 없으므로, 외부에서 setter로 입력 받음
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() { //생성시 uuid 생성해서 저장
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
