package com.arcor.bookingrestaurantapi.controllers;

import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.response.BookingResponse;
import com.arcor.bookingrestaurantapi.services.CancelReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
// conexion para el consumo del front end
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class CancelReservationController {
    
    @Autowired
    CancelReservationService cancelReservationService;

    
    @ResponseStatus(HttpStatus.OK) 
    @RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK", cancelReservationService.deleteReservation(locator));
    }
}
