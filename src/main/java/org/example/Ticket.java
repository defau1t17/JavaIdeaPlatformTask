package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @JsonProperty("carrier")
    private String company;
    @JsonProperty("price")
    private int price;
    @JsonProperty("arrival_time")
    private String arrivalTime;
    @JsonProperty("departure_time")
    private String departureTime;
    @JsonProperty("stops")
    private int stops;
}
