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

    /**
        memberService 빈을 만드는 코드를 보면 memberRepository() 를 호출
        orderService 빈을 만드는 코드도 동일하게 memberRepository() 를 호출
        결과적으로 각각 다른 2개의 MemoryMemberRepository가 생성되면서 싱글톤이 깨지는 것 처럼 보인다.

        But, 모두 같은 인스턴스임.
        Spring이 알아서 싱글톤 보장해 줌.
     **/
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
