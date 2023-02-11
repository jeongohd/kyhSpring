package kyh.spring.beanFind;

import kyh.spring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 빈으로 정의된 이름을 모두 담음
        for (String beanDefinitionName : beanDefinitionNames) { // iter + tab 포문자동생성
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + " object = "+ bean);
        }

    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기") // 내가 등록한 빈들만 출력하기
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 빈으로 정의된 이름을 모두 담음
        for (String beanDefinitionName : beanDefinitionNames) { // iter + tab 포문자동생성
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = " + beanDefinitionName + " object = "+ bean);
            }
        }

    }
}
