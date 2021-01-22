package com.arcor.bookingrestaurantapi.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.arcor.bookingrestaurantapi.dtos.ErrorDto;

public class BookingException extends Exception {
    
    
    private static final long serialVersionUID = 1L;
    private final String code;
    private final int responseCode;


    private final List<ErrorDto> errorList = new ArrayList<>();

    public BookingException(String code, int responseCode, String message) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public BookingException(String code, int responseCode, String message, List<ErrorDto> errorList) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorList.addAll(errorList);
    }


    
    public Object getCode() {
        return this.code;
    }

    
    public Object getResponseCode() {
        return this.responseCode;
    }

    
    
}
