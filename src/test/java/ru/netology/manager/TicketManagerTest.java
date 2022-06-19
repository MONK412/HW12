package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    Ticket ticket1 = new Ticket(17, 3100, "DME", "EGO", 132);
    Ticket ticket2 = new Ticket(802, 5600, "DME", "FRU", 152);
    Ticket ticket3 = new Ticket(34, 1200, "DME", "EGO", 74);
    Ticket ticket4 = new Ticket(1156, 4400, "DME", "EGO", 348);
    Ticket ticket5 = new Ticket(702, 11200, "KUF", "DME", 184);

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void shouldFindAndSort() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("DME", "EGO");
        Ticket[] expected = {ticket3, ticket1, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }
}
