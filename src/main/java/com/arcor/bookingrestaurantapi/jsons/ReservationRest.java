package com.arcor.bookingrestaurantapi.jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {
    
    @JsonProperty("locator")
    private String locator;

    @JsonProperty("restaurantId")
    private String restaurantId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("person")
    private Long person;

    @JsonProperty("turnId")
    private Long turnId;



    public String getLocator() {
        return this.locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPerson() {
        return this.person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }
    
    public Long getTurnId() {
        return this.turnId;
    }

    public void setTurnId(Long turnId) {
        this.turnId = turnId;
    }

}
