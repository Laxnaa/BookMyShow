package com.example.bms.Service;

import com.example.bms.Repository.ShowRepository;
import com.example.bms.models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ShowServiceImpl implements ShowService{
    private ShowRepository showRepository;
    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }
    public Optional<Show> findShowById(int showId){
        return showRepository.findShowById(showId);
    }
}
