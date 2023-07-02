package com.study.object._chapter01.ticket;

public class Bag {
    private Invitation invitation;
    private Ticket ticket;
    private Long amount;

    public Bag(Long amount){
        this(null, amount);
    }

    public Bag(Invitation invitation, Long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }else{
            Long ticketFee = ticket.getFee();
            minusAmount(ticketFee);
            setTicket(ticket);
            return ticketFee;
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    private Long minusAmount(Long amount){
        if(this.amount - amount < 0){
            throw new RuntimeException("보유 금액이 부족해 티켓을 구매할 수 없습니다.");
        }
        return this.amount - amount;
    }

    private Long plusAmount(Long amount){
        return this.amount + amount;
    }

}
