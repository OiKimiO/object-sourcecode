package com.study.object.chapter02.Movie;

public class NonDiscountPolicy extends DiscountPolicy{
    @Override
    public Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
