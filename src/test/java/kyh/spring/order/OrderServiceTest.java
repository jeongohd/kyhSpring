package kyh.spring.order;

import kyh.spring.AppConfig;
import kyh.spring.member.Grade;
import kyh.spring.member.Member;
import kyh.spring.member.MemberService;
import kyh.spring.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L; // primitive type long은 null을 대입할 수 없음.
        Member member = new Member(memberId, "ojg1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "laptop", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
