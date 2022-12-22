package hello.core.annotation;
import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.*;

//@Qualifier("mainDiscountPolicy") 처럼 문자로 적으면 컴파일시 타입 체크가 안되니 다음과 같은 애노테이션 생성
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
