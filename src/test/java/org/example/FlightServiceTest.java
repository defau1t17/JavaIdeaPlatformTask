package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightServiceTest {

    private static TimeConverterService timeConverterService;

    private static TicketModelDummy ticketModelDummy;

    private static FlightService flightService;


    @BeforeAll
    static void init() {
        timeConverterService = new TimeConverterService();
        flightService = new FlightService(timeConverterService);
        ticketModelDummy = new TicketModelDummy();
    }

    @Test
    void findAverageFlightPriceTest() {
        assertEquals(12200, flightService.findAverageFlightPrice(new TicketsModel(ticketModelDummy.getTicketsModels())));
    }

    @Test
    void findAverageFlightPriceTestFailure() {
        assertNotEquals(15000, flightService.findAverageFlightPrice(new TicketsModel(ticketModelDummy.getTicketsModels())));
    }

    @Test
    void findMedianTest() {
        assertEquals(12000.0, flightService.findMedian(new TicketsModel(ticketModelDummy.getTicketsModels())));
    }


}
