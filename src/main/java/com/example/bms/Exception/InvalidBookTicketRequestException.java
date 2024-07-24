package com.example.bms.Exception;

public class InvalidBookTicketRequestException extends Exception{
    public InvalidBookTicketRequestException(String message) {
        super(message);
    }
}
