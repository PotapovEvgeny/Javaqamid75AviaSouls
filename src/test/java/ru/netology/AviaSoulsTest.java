package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket(
            "Perm",
            "Moscow",
            14990,
            23,
            1
    );

    Ticket ticket2 = new Ticket(
            "Perm",
            "Moscow",
            4990,
            12,
            14
    );

    Ticket ticket3 = new Ticket(
            "Perm",
            "Moscow",
            9990,
            4,
            6
    );

    @Test
    public void shouldCompareToReturnPlusOneFirst() {

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToReturnPlusOneSecond() {

        int expected = 1;
        int actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToReturnPlusOneThird() {

        int expected = 1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToReturnMinusOneFirst() {

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToReturnMinusOneSecond() {

        int expected = -1;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToReturnMinusOneThird() {

        int expected = -1;
        int actual = ticket3.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortArrayTicketFirst() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket2, ticket3, ticket1};
        Ticket[] actual = aviaSouls.search("Perm", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortArrayTicketSecond() {
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.search("Perm", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortArrayTicketThird() {

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Perm", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortArrayTicket() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Perm", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
