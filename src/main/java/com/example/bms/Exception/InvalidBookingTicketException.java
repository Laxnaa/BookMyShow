package com.example.bms.Exception;

public class InvalidBookingTicketException extends Exception{
    public InvalidBookingTicketException(String message) {
        super(message);
    }
}
