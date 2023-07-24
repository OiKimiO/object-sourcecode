package com.study.object.chapter04.movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;

    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountConditionType getType(){
        return type;
    };

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time){
        if(type != DiscountConditionType.PERIOD){
            throw new IllegalArgumentException();
        }

        return dayOfWeek.equals(this.dayOfWeek) &&
               time.compareTo(this.startTime) >= 0 &&
               time.compareTo(this.endTime) <= 0;
    }

    public boolean isDiscountable(int sequence){
        if(type != DiscountConditionType.SEQUENCE){
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }
}
