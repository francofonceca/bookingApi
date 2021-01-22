package com.arcor.bookingrestaurantapi.services;

import com.arcor.bookingrestaurantapi.exceptions.BookingException;

public interface EmailService {
    
    public String processedSendEmail(final String receiver, String templateCode, String currentName)
         throws BookingException;
}
