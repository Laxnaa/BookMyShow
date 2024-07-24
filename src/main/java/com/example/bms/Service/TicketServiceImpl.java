package com.example.bms.Service;

import com.example.bms.Exception.InvalidBookingTicketException;
import com.example.bms.Repository.ShowSeatRepository;
import com.example.bms.Repository.TicketRepository;
import com.example.bms.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService {
    private UserService userService;
    private ShowService showService;
    private ShowSeatRepository showSeatService;
    private TicketRepository ticketRepository;
    @Autowired
    public TicketServiceImpl(UserService userService, ShowService showService, ShowSeatRepository showSeatService, TicketRepository ticketRepository) {
        this.userService = userService;
        this.showService = showService;
        this.showSeatService = showSeatService;
        this.ticketRepository = ticketRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookTicket(int userId, int showId, List<Integer> showSeatIds) throws Exception {
        /*
        1. check the presence of userId, if not throws exception
        2. check for the presence of showId, if not throws exception
        3. check the showId of first element in the showSeatList is same as the showId
        4. Start Transaction
        5. select * from show_seats where id in (showSeatIds) and seat_status = 'Available' and show_id = {{showId}} for update
        6. if all the seats are not available then throw error
        7. Update the seatStatus as blocked and insert the updated showseats
        8. Generate ticket
        9. Store in DB
        10. Return stored Ticket
         */

        Optional<User> optionalUser = userService.findUserById(userId);
        if(optionalUser.isEmpty()){
            throw new InvalidBookingTicketException("User is not Valid. ");
        }
        User user = optionalUser.get();

        //this is written using Lambda
        //Show show = this.showService.findById(showId).orElseThrow(() -> new InvalidBookTicketRequestException("Show id is invalid"));
        Optional<Show> optionalShow = showService.findShowById(showId);
        if(optionalShow.isEmpty()){
            throw new InvalidBookingTicketException("Show does not Exist. ");
        }
        Show show = optionalShow.get();

        Optional<ShowSeat> optionalShowSeat = showSeatService.findById(showSeatIds.get(0));
        if(optionalShowSeat.isEmpty()){
            throw new InvalidBookingTicketException("Seat id is invalid.");
        }
        if(optionalShowSeat.get().getShow().getId() != showId){
            throw new InvalidBookingTicketException("given all the seats does not belong to the same Show.");
        }
        List<ShowSeat> showSeatList = showSeatService.findShowSeatByIdInAndSeatStatus_AvailableAndShow(showSeatIds, show);
        if(showSeatList.size() != showSeatIds.size()){
            throw new InvalidBookingTicketException("Some of the tickets you are trying to book are not available");
        }

        //we are BLOCKING after payment verification it gonna be changed to Booked
        for(ShowSeat showSeat: showSeatList){
            showSeat.setBookedBy(user);
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
        }
        showSeatService.saveAll(showSeatList);

        //creating ticket, yet payment is not done
        Ticket ticket = new Ticket();
        ticket.setMovie(show.getMovie());
        ticket.setShow(show);
        ticket.setShowSeat(showSeatList);
        ticket.setUser(user);
        //have to return the inserted ticket, else it doesn't have ticket id.
        return ticketRepository.save(ticket);
    }
}
