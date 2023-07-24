package com.study.object.chapter04.movie;

import com.study.object.chapter02.movie.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount){
        Movie movie = screening.getMovie();
        boolean discountable = movie.isDiscountable(screening.getWhenScreened(), screening.getSequence());

        Money fee = switch (movie.getMovieType()){
                        case AMOUNT_DISCOUNT  -> movie.calculateAmountDiscountedFee();
                        case PERCENT_DISCOUNT -> movie.calculatePercentDiscountedFee();
                        case NONE_DISCOUNT -> movie.calculateNoneDiscountedFee();
                    };

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
