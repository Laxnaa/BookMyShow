package com.example.bms.Controller;

import com.example.bms.Service.TicketService;
import com.example.bms.DTO.BookTicketRequestDTO;
import com.example.bms.DTO.BookTicketResponseDTO;
import com.example.bms.DTO.Response;
import com.example.bms.Exception.InvalidBookTicketRequestException;
import com.example.bms.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {
    TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @RequestMapping(path = "/bookTicket")
    public BookTicketResponseDTO bookTicket (BookTicketRequestDTO requestDTO){
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        try{
            validateBookTicketRequest(requestDTO);
            Ticket ticket = ticketService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatId());
            Response response = Response.getSuccessResponse();
            responseDTO.setTicket(ticket);
            responseDTO.setResponse(response);
        }
        catch(Exception e){
            Response response = Response.getFailureResponse(e.getMessage());
            responseDTO.setResponse(response);
        }
        return responseDTO ;
    }
    public static void validateBookTicketRequest(BookTicketRequestDTO requestDTO) throws InvalidBookTicketRequestException {
        if(requestDTO.getUserId() <= 0){
            throw new InvalidBookTicketRequestException("User id cannot be zero ro negative");
        }
        if(requestDTO.getShowId() <= 0){
            throw new InvalidBookTicketRequestException("Show id cannot be zero ro negative");
        }
        if(requestDTO.getShowSeatId() == null || requestDTO.getShowSeatId().isEmpty()){
            throw new InvalidBookTicketRequestException("Seat id should be present");
        }
        for(int id : requestDTO.getShowSeatId()){
            if(id <= 0){
                throw new InvalidBookTicketRequestException("Show id cannot be zero ro negative");
            }
        }
    }
}
