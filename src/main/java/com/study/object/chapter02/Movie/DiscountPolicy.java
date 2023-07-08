package com.study.object.chapter02.Movie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
