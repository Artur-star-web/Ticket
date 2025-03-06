package ru.netology.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {

    @Test
    void testCompareTo() {
        Ticket t1 = new Ticket("Moscow", "SPb", 5000, 1000, 1200);
        Ticket t2 = new Ticket("Moscow", "SPb", 7000, 1100, 1300);
        assertTrue(t1.compareTo(t2) < 0);
        assertTrue(t2.compareTo(t1) > 0);
    }

    @Test
    void testSearchSortedByPrice() {
        AviaSouls souls = new AviaSouls();
        Ticket t1 = new Ticket("Moscow", "SPb", 5000, 1000, 1200);
        Ticket t2 = new Ticket("Moscow", "SPb", 3000, 1100, 1300);
        Ticket t3 = new Ticket("Moscow", "SPb", 7000, 900, 1100);
        souls.add(t1);
        souls.add(t2);
        souls.add(t3);
        Ticket[] expected = {t2, t1, t3};
        assertArrayEquals(expected, souls.search("Moscow", "SPb"));
    }

    @Test
    void testSearchAndSortByTime() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket t1 = new Ticket("Moscow", "SPb", 5000, 1000, 1200);
        Ticket t2 = new Ticket("Moscow", "SPb", 3000, 1100, 1300);
        Ticket t3 = new Ticket("Moscow", "SPb", 7000, 900, 1000);
        souls.add(t1);
        souls.add(t2);
        souls.add(t3);
        Ticket[] expected = {t3, t1, t2};
        assertArrayEquals(expected, souls.searchAndSortBy("Moscow", "SPb", comparator));
    }
}
