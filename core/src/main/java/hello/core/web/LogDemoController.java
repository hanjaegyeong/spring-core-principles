package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// 로거가 잘 작동하는지 확인하는 테스트용 컨트롤러다
@Controller
@RequiredArgsConstructor // 생성자주입과 동일. 즉 필드들 전부 자동 주입된 것
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody // 리턴객체(json등)을 클라이언트(http)단에 넘겨줌
    public String logDeme(HttpServletRequest request) { // HttpServletRequest를 통해서 요청 URL을 받음. requestURL값: http://localhost:8080/log-demo
        String requestURL = request.getRequestURL().toString(); // requestURL 값을 myLogger에 저장
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK"; //클라이언트에 넘길 리턴객체
    }
}
