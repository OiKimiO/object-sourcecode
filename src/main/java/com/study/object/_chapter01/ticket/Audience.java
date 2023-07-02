package com.study.object._chapter01.ticket;

public class Audience {

    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Long buy(Ticket ticket){
        if(this.bag.hasInvitation()){
            this.bag.setTicket(ticket);
            return 0L;
        }else{
            Long ticketFee = ticket.getFee();
            this.bag.minusAmount(ticketFee);
            this.bag.setTicket(ticket);
            return ticketFee;
        }
    }
}
