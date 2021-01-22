package com.arcor.bookingrestaurantapi.services.impl;

import com.arcor.bookingrestaurantapi.entities.Reservation;
import com.arcor.bookingrestaurantapi.entities.Restaurant;
import com.arcor.bookingrestaurantapi.entities.Turn;
import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.arcor.bookingrestaurantapi.exceptions.NotFoundException;
import com.arcor.bookingrestaurantapi.jsons.CreateReservationRest;
import com.arcor.bookingrestaurantapi.jsons.ReservationRest;
import com.arcor.bookingrestaurantapi.repositories.ReservationRepository;
import com.arcor.bookingrestaurantapi.repositories.RestaurantRepository;
import com.arcor.bookingrestaurantapi.repositories.TurnRepository;
import com.arcor.bookingrestaurantapi.services.ReservationService;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    // creo un modelMapper
    public static final ModelMapper modelMapper = new ModelMapper();
    

    // metodo de crear reserva 
    public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

        // verifico de que el restaurante exista -> obtengo el id del restaurant llegado en createReservationRest
        // busco un findById para buscarlo en la base de datos y en caso de que no lo encuentre, devuelvo un error de RESTAURANT NOT FOUND
        final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
                .orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));

        final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
                .orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));

        // Creo locator que es el valor de la bd
        String locator = generateLocator(restaurantId, createReservationRest);

        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson());
        reservation.setDate(createReservationRest.getDate());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turn.getName());
        reservation.setName(createReservationRest.getName());
        reservation.setEmail(createReservationRest.getEmail());
 
        try{
            reservationRepository.save(reservation);
        }catch (final Exception e){
            LOGGER.error("INTEERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return locator;
    }

    private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest) throws BookingException {
        return restaurantId.getName() + createReservationRest.getTurnId();
    }

    public ReservationRest getReservationById(@PathVariable Long reservationId) throws BookingException {
        // devuelvo la informacion del restaurante encontrado con esa Id
        return modelMapper.map(getReservationEntity(reservationId), ReservationRest.class);
    }

    private Reservation getReservationEntity(Long reservationId) throws BookingException {

        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESERVATION_NOT_FOUND"));
    }

}
