package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

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
        return ticketsModel
                .getTickets()
                .stream()
                .mapToInt(Ticket::getPrice)
                .sum() / ticketsModel.getTickets().size();
    }

    public double findMedian(TicketsModel ticketsModel) {
        List<Integer> collect = ticketsModel
                .getTickets()
                .stream()
                .mapToInt(Ticket::getPrice)
                .sorted().boxed()
                .collect(Collectors.toList());
        int middle = collect.size() / 2;
        return (collect.size() % 2 == 0) ? (double) (collect.get(middle - 1) + collect.get(middle)) / 2 : collect.get(middle);
    }
}

