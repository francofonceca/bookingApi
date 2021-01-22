package com.arcor.bookingrestaurantapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.arcor.bookingrestaurantapi.entities.Restaurant;
import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.exceptions.NotFoundException;
import com.arcor.bookingrestaurantapi.jsons.RestaurantRest;
import com.arcor.bookingrestaurantapi.repositories.RestaurantRepository;
import com.arcor.bookingrestaurantapi.services.RestaurantService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    // creo la clase donde obtengo todo de restaurant
    @Autowired
    RestaurantRepository restaurantRepository;


    // creo un modelMapper
    public static final ModelMapper modelMapper = new ModelMapper();

    
    public RestaurantRest getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
        // devuelvo la informacion del restaurante encontrado con esa Id
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }

    public RestaurantRest getRestaurantsByName(@PathVariable String restaurantName) throws BookingException {
         // devuelvo la informacion del restaurante encontrado con esa Name
         return modelMapper.map(getRestaurantEntityByName(restaurantName), RestaurantRest.class);
    }


    // obtener todos los restaurantes

    public List<RestaurantRest> getRestaurants() throws BookingException {
        
        final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();

        return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestaurantRest.class) ).collect(Collectors.toList());

    }

    // verificar si existe restaurante con id

    private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {

        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));

    }


    // verificar si existe restaurante con nombre

    private Restaurant getRestaurantEntityByName(String restaurantName) throws BookingException {

        return restaurantRepository.findByName(restaurantName)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));

    }
    
}
