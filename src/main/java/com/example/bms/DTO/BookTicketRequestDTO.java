package com.example.bms.DTO;

import lombok.Data;

import java.util.List;
@Data
public class BookTicketRequestDTO {
    private int userId;
    private List<Integer> showSeatId;
    private int showId;
    //showSeatId is enough, the only reason we are adding showId is for verification purpose

}
