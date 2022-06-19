package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {
    Ticket ticket1 = new Ticket(17, 3100, "DME", "EGO", 132);
    Ticket ticket2 = new Ticket(802, 5600, "LED", "FRU", 152);
    Ticket ticket3 = new Ticket(34, 1200, "DME", "EGO", 74);
    Ticket ticket4 = new Ticket(1156, 4400, "DME", "EGO", 348);
    Ticket ticket5 = new Ticket(702, 11200, "KUF", "DME", 184);

    TicketRepository repo = new TicketRepository();

    @Test
    public void removeId() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.removeByID(34);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void generateException() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeByID(-123);
        });
    }

    @Test
    public void findId() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        Ticket[] actual = repo.findById(1156);
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }
}
