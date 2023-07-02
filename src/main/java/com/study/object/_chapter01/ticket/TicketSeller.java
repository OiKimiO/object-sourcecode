package com.study.object._chapter01.ticket;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        Ticket ticket = this.ticketOffice.getTicket();
        Long ticketFee = audience.buy(ticket);
        this.ticketOffice.plusAmount(ticketFee);
    }
}
