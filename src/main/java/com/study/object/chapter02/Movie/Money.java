package com.study.object.chapter02.Movie;

import java.math.BigDecimal;

public class Money {
    public final Money ZERO = wons(0L);

    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money amount){
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount){
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent){
        return new Money(this.amount.multiply(new BigDecimal(percent)));
    }

    public boolean isLessThan(Money other){
        return this.amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThan(Money other){
        return this.amount.compareTo(other.amount) >= 0;
    }
}
