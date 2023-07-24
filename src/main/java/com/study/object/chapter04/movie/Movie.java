package com.study.object.chapter04.movie;

import com.study.object.chapter02.movie.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Movie {
    private String title;
    private Duration duration;
    private Money fee;
    private List<DiscountCondition> discountConditions = new ArrayList<>();

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public Money calculateAmountDiscountedFee(){
        if(movieType != MovieType.AMOUNT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee(){
        if(movieType != MovieType.PERCENT_DISCOUNT){
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee(){
        if(movieType != MovieType.NONE_DISCOUNT){
            throw new IllegalArgumentException();
        }

        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence){
        for (DiscountCondition condition : discountConditions) {
            if(condition.getType() == DiscountConditionType.PERIOD){
                if(condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())){
                    return true;
                }
            }else{
                if(condition.isDiscountable(sequence)){
                    return true;
                }
            }
        }

        return false;
    }
}
