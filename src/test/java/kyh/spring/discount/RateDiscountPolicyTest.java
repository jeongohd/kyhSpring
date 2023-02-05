package kyh.spring.discount;

import kyh.spring.member.Grade;
import kyh.spring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10%할인이 되어야 한다")
    void vip_o() {
        // g
        Member m = new Member(1L, "ojg", Grade.VIP);
        // w
        int discount = discountPolicy.discount(m, 10000);
        // t
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        // g
        Member m = new Member(2L, "ojg2", Grade.Basic);
        // w
        int discount = discountPolicy.discount(m, 10000);
        // t
        assertThat(discount).isEqualTo(0);
    }

}