package com.study.object._chapter01.ticket;

public class Audience {

    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){
        return this.bag;
    }

    public Long buy(Ticket ticket) {
        return this.bag.hold(ticket);
    }
}
