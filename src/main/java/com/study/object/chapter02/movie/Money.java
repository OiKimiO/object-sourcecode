package com.study.object.chapter02.movie;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@ToString
public class Money {
    public static final Money ZERO = Money.wons(0);

    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        return amount.compareTo(money.amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
