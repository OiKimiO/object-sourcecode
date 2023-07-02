package com.study.object._chapter01.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TicketTest {
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
    public void 초대장_있는_관람객은_입장합니다(){
        // given
        this.bag = new Bag(this.invitation,0L);
        this.audience = new Audience(this.bag);

        // when
        theater.enter(audience);
    }

    @Test
    public void 초대장_없는_관람객_지불후_입장합니다(){
        // given
        this.bag = new Bag(6000L);
        this.audience = new Audience(this.bag);

        // when
        theater.enter(audience);
    }

    @Test
    public void 티켓구매_금액이_없는_관람객(){
        // given
        this.bag = new Bag(0L);
        this.audience = new Audience(this.bag);

        // when, then
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> {
            this.theater.enter(audience);
        });

        assertThat(runtimeException.getMessage()).isEqualTo("보유 금액이 부족해 티켓을 구매할 수 없습니다.");
    }

}
