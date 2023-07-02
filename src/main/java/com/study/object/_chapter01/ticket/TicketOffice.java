package com.study.object._chapter01.ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private List<Ticket> tickets = new ArrayList<>();
    private Long amount;

    public TicketOffice(Long amount, Ticket ...ticket){
        this.amount = amount;
        tickets.addAll(List.of(ticket));
    }

    public Ticket getTicket(){
        return tickets.remove(0);
    }

    public Long minusAmount(Long amount){
        return this.amount - amount;
    }

    public Long plusAmount(Long amount){
        return this.amount + amount;
    }
}
