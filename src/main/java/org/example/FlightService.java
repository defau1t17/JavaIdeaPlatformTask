package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class FlightService {


    private TimeConverterService timeConverterService;

    public FlightService(TimeConverterService timeConverterService) {
        this.timeConverterService = timeConverterService;
    }

    public HashMap<String, Long> getMinimumFlightTime(TicketsModel ticketsModel) {
        HashMap<String, Long> minimum = new HashMap<>();
        ticketsModel.getTickets().stream().forEach(fly -> {
            long diff = timeConverterService.getDifferenceBetweenTimes(fly.getArrivalTime(), fly.getDepartureTime());
            if (minimum.get(fly.getCompany()) != null && diff < minimum.get(fly.getCompany()))
                minimum.replace(fly.getCompany(), diff);
            else if (minimum.get(fly.getCompany()) == null) minimum.put(fly.getCompany(), diff);
        });
        return minimum;
    }

    public double findAverageFlightPrice(TicketsModel ticketsModel) {
        return ticketsModel.getTickets().stream().mapToInt(Ticket::getPrice).sum() / ticketsModel.getTickets().size();
    }

    public double findMedian(TicketsModel ticketsModel) {
        return ticketsModel.getTickets().stream().mapToInt(Ticket::getStops).sum() / 2;
    }

}

