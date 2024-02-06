package org.example;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TicketsModel {
    @JsonProperty("tickets")
    private List<Ticket> tickets;
}
