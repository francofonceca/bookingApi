package com.arcor.bookingrestaurantapi.jsons;

import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantRest {
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("name")
    @Column( name = "name")
    private String name;
    
    @JsonProperty("address")
    @Column( name = "address")
    private String address;

    @JsonProperty("description")
    @Column( name = "description")
    private String description;

    @JsonProperty("image")
    @Column( name = "image")
    private String image;

    @JsonProperty("turn")
    private List<TurnRest> turns;
     
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<TurnRest> getTurns() {
        return this.turns;
    }

    public void setTurns(List<TurnRest> turns) {
        this.turns = turns;
    }
    
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
