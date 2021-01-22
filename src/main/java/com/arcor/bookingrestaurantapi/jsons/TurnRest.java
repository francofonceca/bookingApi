package com.arcor.bookingrestaurantapi.jsons;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TurnRest {
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("name")
    @Column( name = "name")
    private String name;
    
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
}
