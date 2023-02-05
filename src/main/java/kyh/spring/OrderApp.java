package kyh.spring;

import kyh.spring.member.Grade;
import kyh.spring.member.Member;
import kyh.spring.member.MemberService;
import kyh.spring.member.MemberServiceImpl;
import kyh.spring.order.Order;
import kyh.spring.order.OrderService;
import kyh.spring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();



        Long memberId = 1L;
        Member member = new Member(memberId, "ojg1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "laptop", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = "+order.calculatePrice());

    }
}
