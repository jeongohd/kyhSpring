package kyh.spring;

import kyh.spring.member.Grade;
import kyh.spring.member.Member;
import kyh.spring.member.MemberService;
import kyh.spring.member.MemberServiceImpl;
import kyh.spring.order.Order;
import kyh.spring.order.OrderService;
import kyh.spring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        // 스프링 컨테이너 생성
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "ojg1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "laptop", 20000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = "+order.calculatePrice());

    }
}
