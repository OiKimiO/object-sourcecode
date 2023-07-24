package com.study.object.chapter04.movie;

import com.study.object.chapter02.movie.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount){
        Movie movie = screening.getMovie();
        boolean discountable = false;
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            discountable = switch(condition.getType()){
                                case PERIOD -> condition.isDiscountable(screening.getWhenScreened().getDayOfWeek(),
                                                                        screening.getWhenScreened().toLocalTime());
                                case SEQUENCE -> condition.isDiscountable(screening.getSequence());
                            };

            if(discountable){
                break;
            }
        }

        Money fee;
        if(discountable){
            Money discountAmount = switch (movie.getMovieType()){
                                        case AMOUNT_DISCOUNT  -> movie.getDiscountAmount();
                                        case PERCENT_DISCOUNT -> movie.getFee().times(movie.getDiscountPercent());
                                        default -> Money.ZERO;
                                    };

            fee = movie.getFee().minus(discountAmount);
        }else{
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
