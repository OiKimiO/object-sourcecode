package com.study.object.chapter04.movie;

import com.study.object.chapter02.movie.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount){
        return switch(movie.getMovieType()){
            case AMOUNT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)){
                    yield movie.calculateAmountDiscountedFee().times(audienceCount);
                }
                yield movie.calculateNoneDiscountedFee().times(audienceCount);
            }
            case PERCENT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)){
                    yield movie.calculatePercentDiscountedFee().times(audienceCount);
                }
                yield movie.calculateNoneDiscountedFee().times(audienceCount);
            }
            default -> movie.calculateNoneDiscountedFee().times(audienceCount);
        };
    }
}
