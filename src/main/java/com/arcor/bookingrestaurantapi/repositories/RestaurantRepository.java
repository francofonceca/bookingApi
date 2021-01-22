package com.arcor.bookingrestaurantapi.repositories;

import java.util.List;
import java.util.Optional;

import com.arcor.bookingrestaurantapi.entities.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

    Optional<Restaurant> findById(String string);

    Optional<Restaurant> findByName(String restaurantName);

    @Query( "SELECT REST FROM Restaurant REST")
    public List<Restaurant> findByRestaurants();

}
