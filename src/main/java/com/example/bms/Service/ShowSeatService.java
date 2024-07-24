package com.example.bms.Service;

import com.example.bms.Repository.ShowSeatRepository;
import com.example.bms.models.Show;
import com.example.bms.models.ShowSeat;

import java.util.List;
import java.util.Optional;

public interface ShowSeatService {

    public Optional<ShowSeat> findById(int showSeatId);
    public List<ShowSeat> findShowSeatByIdInAndSeatStatus_AvailableAndShow(List<Integer> showSeatids, Show show);
    public void saveAll(List<ShowSeat> showSeatList);
}
