package com.arcor.bookingrestaurantapi.controllers;

import java.util.List;

import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.jsons.RestaurantRest;
import com.arcor.bookingrestaurantapi.response.BookingResponse;
import com.arcor.bookingrestaurantapi.services.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
// conexion para el consumo del front end
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
    
    // PETICION GET PARA OBTENER DATOS DE UN RESTAURANTE SEGUN ID

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId" 
        + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        // obtengo desde get restaurantId y se la envio a getRestaurantById para returnarlo como un objeto tipo BookingResponse
    public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId));
    }

     
    // PETICION GET PARA OBTENER DATOS DE UN RESTAURANTE SEGUN ID

    // @ResponseStatus(HttpStatus.OK)
    // @RequestMapping(value = "restaurant" + "/{" + "restaurantName" 
    //     + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    // public BookingResponse<RestaurantRest> getRestaurantsByName(@PathVariable String restaurantName) throws BookingException {
    //     return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
    //             restaurantService.getRestaurantsByName(restaurantName));
    // }


    // PETICION GET PARA OBTENER TODOS LOS RESTAURANTES
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingException{
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurants());
    }

}
