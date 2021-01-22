package com.arcor.bookingrestaurantapi.jsons;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateReservationRest {
    
    @JsonProperty("date")
    private Date date;

    @JsonProperty("person")
    private Long person;

    @JsonProperty("turnId")
    private Long turnId;

    @JsonProperty("restaurantId")
    private Long restaurantId;

    @JsonProperty("name")

    private String name;

    @JsonProperty("email")
    private String email;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
   

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
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
