package com.example.bms.Service;

import com.example.bms.Repository.ShowSeatRepository;
import com.example.bms.models.Show;
import com.example.bms.models.ShowSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ShowSeatServiceImpl implements ShowSeatService  {
    private ShowSeatRepository showSeatRepository;
    @Autowired
    public ShowSeatServiceImpl(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    public Optional<ShowSeat> findById(int showSeatId){
        return showSeatRepository.findById(showSeatId);
    }

    @Override
    public List<ShowSeat> findShowSeatByIdInAndSeatStatus_AvailableAndShow(List<Integer> showSeatIds, Show show) {
        return showSeatRepository.findShowSeatByIdInAndSeatStatus_AvailableAndShow(showSeatIds, show);
    }
    public void saveAll(List<ShowSeat> showSeatList){
        showSeatRepository.saveAll(showSeatList);
    }
}
