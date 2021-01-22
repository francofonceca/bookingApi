package com.arcor.bookingrestaurantapi.services.impl;

import com.arcor.bookingrestaurantapi.entities.Reservation;
import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.arcor.bookingrestaurantapi.exceptions.NotFoundException;
import com.arcor.bookingrestaurantapi.repositories.ReservationRepository;
import com.arcor.bookingrestaurantapi.services.CancelReservationService;
import com.arcor.bookingrestaurantapi.services.EmailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelReservationServiceImpl implements CancelReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EmailService emailService;

    public String deleteReservation(String locator) throws BookingException {

        Reservation  reservation =  reservationRepository.findByLocator(locator)
            .orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));

        try{    

            reservationRepository.deleteByLocator(locator);

        }catch (final Exception e){
            LOGGER.error("INTEERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        
        this.emailService.processedSendEmail(reservation.getEmail(), "CANCEL", reservation.getName());
        return "LOCATOR_DELETED";

    }
    
}
