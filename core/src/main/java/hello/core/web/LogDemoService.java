package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider; //웹 접속 URL 로그 띄우기.

    public void logic(String id) {
        MyLogger myLogger = myLoggerProvider.getObject(); //요기서 get으로 꺼내기
        myLogger.log("service id = " + id);
    }
}
