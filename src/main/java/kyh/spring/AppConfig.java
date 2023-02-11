package kyh.spring;

import kyh.spring.discount.DiscountPolicy;
import kyh.spring.discount.FixDiscountPolicy;
import kyh.spring.discount.RateDiscountPolicy;
import kyh.spring.member.MemberRepository;
import kyh.spring.member.MemberService;
import kyh.spring.member.MemberServiceImpl;
import kyh.spring.member.MemoryMemberRepository;
import kyh.spring.order.OrderService;
import kyh.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정정보
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
