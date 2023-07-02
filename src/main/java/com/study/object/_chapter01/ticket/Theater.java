package com.study.object._chapter01.ticket;

public class Theater {
    private TicketSeller ticketSeller;

    public void enter(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            Long ticketFee = ticket.getFee();
            Long audienceAmount = audience.getBag().minusAmount(ticketFee);
            ticketSeller.getTicketOffice().plusAmount(audienceAmount);
            audience.getBag().setTicket(ticket);
        }
    }
}
