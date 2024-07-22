package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
@Entity(name = "tickets")
public class Ticket extends BaseModel{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Show show;
    @OneToMany(mappedBy = "ticker")
    private List<ShowSeat> showseat;
    @ManyToOne
    private User user;
}
