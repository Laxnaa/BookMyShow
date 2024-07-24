package com.example.bms.Service;

import com.example.bms.models.Ticket;

import java.util.List;

public interface TicketService {
public Ticket bookTicket(int userId, int showId, List<Integer> showSeatId) throws Exception;
}
