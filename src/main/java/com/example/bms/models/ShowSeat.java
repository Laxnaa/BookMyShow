package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "show_seats")
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(value =  EnumType.ORDINAL)
    // if you don't specify the @Enumerated annotation,
    // JPA will persist the enum value as an ordinal by default.
    private SeatStatus seatStatus;
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Ticket ticket;
}
