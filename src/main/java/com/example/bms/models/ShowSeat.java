package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "show_seats")
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    private SeatStatus seatStatus;
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Ticket ticket;
}
