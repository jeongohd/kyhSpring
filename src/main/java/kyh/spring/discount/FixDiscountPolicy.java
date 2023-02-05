package kyh.spring.discount;

import kyh.spring.member.Grade;
import kyh.spring.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // Enum은 비교를 == 으로 함.
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
