package com.arcor.bookingrestaurantapi.controllers;

import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.jsons.CreateReservationRest;
import com.arcor.bookingrestaurantapi.jsons.ReservationRest;
import com.arcor.bookingrestaurantapi.response.BookingResponse;
import com.arcor.bookingrestaurantapi.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
// conexion para el consumo del front end
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {
    
    @Autowired
    ReservationService reservationService;

    // ENDPOINT PARA CREAR UNA RESERVA
    @ResponseStatus(HttpStatus.OK) 
    @RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> createReservation (@RequestBody CreateReservationRest createReservationRest)
             throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
             reservationService.createReservation(createReservationRest));
    }
    
    
    // ENDPOINT GET PARA OBTENER DATOS DE UNA RESERVA SEGUN ID

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation" + "/{" + "reservationId" 
        + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<ReservationRest> getReservation(@PathVariable Long reservationId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                reservationService.getReservationById(reservationId));
    }

}
