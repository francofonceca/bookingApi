package com.arcor.bookingrestaurantapi.services;

import com.arcor.bookingrestaurantapi.exceptions.BookingException;

public interface CancelReservationService {

    public String deleteReservation(String locator) throws BookingException;
    
}
