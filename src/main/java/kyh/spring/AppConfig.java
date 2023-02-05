package kyh.spring;

import kyh.spring.discount.FixDiscountPolicy;
import kyh.spring.member.MemberService;
import kyh.spring.member.MemberServiceImpl;
import kyh.spring.member.MemoryMemberRepository;
import kyh.spring.order.OrderService;
import kyh.spring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
