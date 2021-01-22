package com.arcor.bookingrestaurantapi.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )  
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column( name = "locator")
    private String locator;

    @Column( name = "turn")
    private String turn;
    
    @Column( name = "person")
    private Long person;

    @Column( name="date")
    private Date date;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "payment")
    private boolean payment;


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean getPayment() {
        return this.payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLocator() {
        return this.locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getTurn() {
        return this.turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public Long getPerson() {
        return this.person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
