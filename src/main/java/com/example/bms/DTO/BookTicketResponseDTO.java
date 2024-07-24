package com.example.bms.DTO;

import com.example.bms.models.Ticket;
import lombok.Data;

@Data
public class BookTicketResponseDTO {
    private Response response;
    private Ticket ticket;
}
