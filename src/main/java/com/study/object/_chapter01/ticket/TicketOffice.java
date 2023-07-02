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

    private Ticket getTicket(){
        return tickets.remove(0);
    }

    private Long minusAmount(Long amount){
        return this.amount - amount;
    }

    private Long plusAmount(Long amount){
        return this.amount + amount;
    }

    public void sellTicketTo(Audience audience) {
        Ticket ticket = getTicket();
        Long ticketFee = audience.buy(ticket);
        plusAmount(ticketFee);
    }
}
