package org.example;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TicketsModel {
    @JsonProperty("tickets")
    private List<Ticket> tickets;
}
