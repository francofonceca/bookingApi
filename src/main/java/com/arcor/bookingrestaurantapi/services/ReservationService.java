package com.arcor.bookingrestaurantapi.services;

import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.jsons.CreateReservationRest;
import com.arcor.bookingrestaurantapi.jsons.ReservationRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

public interface ReservationService {
 
    
    @Autowired
    ReservationRest getReservationById(@PathVariable Long restaurantId) throws BookingException;

    String createReservation(CreateReservationRest createReservationRest) throws BookingException;

}
