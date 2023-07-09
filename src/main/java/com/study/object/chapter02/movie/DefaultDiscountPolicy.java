package com.study.object.chapter02.movie;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = List.of(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each: conditions){
            if(each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    public abstract Money getDiscountAmount(Screening screening);
}
