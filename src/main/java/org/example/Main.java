package org.example;


public class Main {

    private static FlightService service;
    private static ParserService<TicketsModel> parserService;


    private static final TimeConverterService converterService = new TimeConverterService();

    static {
        service = new FlightService(converterService);
        parserService = new ParserService<>();
    }

    public static void main(String[] args) throws Exception {
        TicketsModel parsedData = parserService.getParsedData("src/main/resources/tickets.json", TicketsModel.class);
        service.getMinimumFlightTime(parsedData).entrySet().forEach(entry -> {
            System.out.println(String.format("Company '%s' completed the flight over %s", entry.getKey(), converterService.convertSecondsToNormalTime(entry.getValue())));
        });
        System.out.println("|------------------------------------------------------------------|");
        System.out.println(String.format("Difference between average flight price and median = %s", (service.findAverageFlightPrice(parsedData) - service.findMedian(parsedData))));
    }
}