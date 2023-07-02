package com.study.object._chapter01.ticket;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = this.ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = this.ticketOffice.getTicket();
            Long ticketFee = ticket.getFee();
            Long audienceAmount = audience.getBag().minusAmount(ticketFee);
            this.ticketOffice.plusAmount(audienceAmount);
            audience.getBag().setTicket(ticket);
        }
    }
}
