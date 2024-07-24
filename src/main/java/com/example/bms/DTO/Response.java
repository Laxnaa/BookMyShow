package com.example.bms.DTO;

import lombok.Data;

import java.security.PrivateKey;
@Data
public class Response {
    private String error;
    private ResponseStatus responseStatus;

    public Response(String error, ResponseStatus responseStatus) {
        this.error = error;
        this.responseStatus = responseStatus;
    }

    public static Response getFailureResponse(String message){
        return new Response(message, ResponseStatus.FAILURE);
    }
    public static Response getSuccessResponse(){
        return  new Response(null, ResponseStatus.SUCCESS);
    }
}
