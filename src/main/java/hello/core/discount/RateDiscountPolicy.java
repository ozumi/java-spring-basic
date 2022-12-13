package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 20;

    @Override
    public int discount(Member member, int price) {
        if (member.getGarde() == Grade.VIP){
            return price * discountPercent / 100;
        }
        return 0;
    }
}
