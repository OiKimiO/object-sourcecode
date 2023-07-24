package com.study.object.chapter04.movie;

import com.study.object.chapter02.movie.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount){
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
