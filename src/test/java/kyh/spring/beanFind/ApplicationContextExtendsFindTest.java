package kyh.spring.beanFind;

import kyh.spring.discount.DiscountPolicy;
import kyh.spring.discount.FixDiscountPolicy;
import kyh.spring.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면 중복오류 발생. ")
    void findBeanByParentTypeDuplicate() {
//        ac.getBean(DiscountPolicy.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면 빈 이름을 지정하여 해결. ")
    void findBeanByParentTypeDuplicate2() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
//        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->ac.getBean(DiscountPolicy.class));
    }


}
