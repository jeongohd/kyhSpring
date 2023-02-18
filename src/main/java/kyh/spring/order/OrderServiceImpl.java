package kyh.spring.order;

import kyh.spring.discount.DiscountPolicy;
import kyh.spring.discount.FixDiscountPolicy;
import kyh.spring.discount.RateDiscountPolicy;
import kyh.spring.member.Member;
import kyh.spring.member.MemberRepository;
import kyh.spring.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {


    /**
         OrderServiceImpl은 DiscountPolicy 인터페이스에만 의존해야 함(DIP)
         하지만 FixDiscountPolicy / RateDiscountPolicy 구현체에도 의존하고 있어 DIP위반.
         DIP : 인터페이스에만 의존해야 하는 것.
     **/

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    private DiscountPolicy discountPolicy; // DIP 의존에 성립.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     OrderServiceImpl은 생성자를 통해서 어떤 구현 객체(FixDiscount / RateDiscount)가 들어올지 알 수 없음.
     OrderServiceImpl의 생성자를 통해 어떤 구현 객체를 주입할 지는 오직 외부(AppConfig)에서 결정.
     OrderServiceImpl은 실행에만 집중함.
     */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // nullPointException 발생.
        // 문제 해결을 위해, OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해주어야 함.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
