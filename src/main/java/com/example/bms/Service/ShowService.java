package com.example.bms.Service;

import com.example.bms.models.Show;

import java.util.Optional;

public interface ShowService {
    public Optional<Show> findShowById(int showId);
}
