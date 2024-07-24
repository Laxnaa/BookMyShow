package com.example.bms.Repository;

import com.example.bms.models.Show;
import com.example.bms.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    Optional<ShowSeat> findById(int ShowSeat);

    //to make it for update
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findShowSeatByIdInAndSeatStatus_AvailableAndShow(List<Integer> showSeatIds, Show show);

    //instead we can write our query using @Query
    //@Query(value = "select * from show_seats where id in (showSeatIds) and seat_status = 'Available' and show_id = {{showId}} for update")

    void saveAll(List<ShowSeat> showSeatList);
    //we don't need to write this, it is already present it crud repository
}
