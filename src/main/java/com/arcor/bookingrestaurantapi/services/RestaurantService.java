package com.arcor.bookingrestaurantapi.services;

import java.util.List;

import com.arcor.bookingrestaurantapi.exceptions.BookingException;
import com.arcor.bookingrestaurantapi.jsons.RestaurantRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface RestaurantService {
    
    @Autowired
    RestaurantRest getRestaurantById(@PathVariable Long restaurantId) throws BookingException;
    
    @Autowired
    RestaurantRest getRestaurantsByName(@PathVariable String restaurantName) throws BookingException;

    public List<RestaurantRest> getRestaurants() throws BookingException;
}
