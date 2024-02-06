package org.example;

import java.util.List;

public class TicketModelDummy {
    private List<Ticket> ticketsModels = List.of(
            new Ticket("J7", 12000, "16:30", "22:00", 0),
            new Ticket("S7", 15000, "16:30", "22:00", 1),
            new Ticket("K7", 11000, "16:30", "22:00", 2),
            new Ticket("B7", 10000, "16:30", "22:00", 3),
            new Ticket("G7", 13000, "16:30", "22:00", 4)
    );

    public List<Ticket> getTicketsModels() {
        return this.ticketsModels;
    }


}
