package com.study.object.chapter02.Movie;

import java.util.ArrayList;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = List.of(conditions);
    }

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
