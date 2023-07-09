package com.study.object.chapter02.movie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
