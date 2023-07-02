package com.study.object._chapter01.ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TicketSellerTest {
    private TicketOffice ticketOffice;
    private Invitation invitation;
    private TicketSeller ticketSeller;
    private Theater theater;
    private Audience audience;
    private Bag bag;

    @BeforeEach
    void 테스트_공통_입력값(){
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        this.ticketOffice = new TicketOffice(10000L, ticket1, ticket2);
        this.ticketSeller = new TicketSeller(ticketOffice);
        this.theater = new Theater(ticketSeller);
        this.invitation = new Invitation();
    }

    @Test
    public void 초대장_없는_관람객에게_판매하세요(){
        // given
        this.bag = new Bag(6000L);
        this.audience = new Audience(this.bag);

        // when
        theater.enter(audience);

        // then
        assertThat(this.bag.hasTicket()).isTrue();
    }

    @Test
    public void 초대장_있는_관람객에게_판매하세요(){
        // given
        this.bag = new Bag(invitation,0L);
        this.audience = new Audience(this.bag);

        // when
        theater.enter(audience);

        // then
        assertThat(this.bag.hasTicket()).isTrue();
    }
}
