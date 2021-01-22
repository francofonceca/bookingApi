package com.arcor.bookingrestaurantapi.exceptions;

import java.util.Arrays;

import com.arcor.bookingrestaurantapi.dtos.ErrorDto;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BookingException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String code, String message) {
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }
    
    public NotFoundException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
    
}
