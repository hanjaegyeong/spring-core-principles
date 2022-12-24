package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger; //웹 접속 URL 로그 띄우기.

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
