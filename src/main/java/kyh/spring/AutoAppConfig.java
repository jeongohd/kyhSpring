package kyh.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration() // 설정정보 파일이라고 지정
@ComponentScan( // @component 어노테이션이 붙은 클래스를 찾아 자동으로 빈으로 등록.
        basePackages = "kyh.spring",
        // basePackages = {"hello.core", "hello.service"}
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // Configuration.class component 는 제외한 나머지 빈들을 자동으로 등록.
)
public class AutoAppConfig {

}
