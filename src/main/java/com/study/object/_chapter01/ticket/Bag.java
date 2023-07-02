package com.study.object._chapter01.ticket;

public class Bag {
    private Invitation invitation;
    private Ticket ticket;
    private Long amount;

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public Long minusAmount(Long amount){
        return this.amount - amount;
    }

    public Long plusAmount(Long amount){
        return this.amount + amount;
    }

}
