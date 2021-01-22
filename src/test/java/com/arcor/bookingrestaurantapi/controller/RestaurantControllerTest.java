// package com.arcor.bookingrestaurantapi.controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import com.arcor.bookingrestaurantapi.controllers.RestaurantController;
// import com.arcor.bookingrestaurantapi.entities.Restaurant;
// import com.arcor.bookingrestaurantapi.exceptions.BookingException;
// import com.arcor.bookingrestaurantapi.jsons.RestaurantRest;
// import com.arcor.bookingrestaurantapi.response.BookingResponse;
// import com.arcor.bookingrestaurantapi.services.RestaurantService;

// import org.junit.Before;
// import org.junit.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// public class RestaurantControllerTest {

//     private static final Long RESTAURANT_ID = 1L;
//     private static final String NAME = "Burger";
//     private static final String DESC = "Todo timpo de hamburguesas";
//     private static final String ADDRES = "Av. Peron";
//     private static final String IMAGE = "www.image.com";

//     private static final String SUCCESS_STATUS = "Success";
//     private static final String SUCCESS_CODE = "200 OK";
//     private static final String OK = "OK";

//     public static final RestaurantRest RESTAURANT_RES = new RestaurantRest();

//     @Mock
//     RestaurantService restaurantService;

//     @InjectMocks
//     RestaurantController restaurantController;

//     @Before
//     public void init() throws BookingException {
        
//         MockitoAnnotations.initMocks(this);

//         RESTAURANT_RES.setName(NAME);
//         RESTAURANT_RES.setDescription(DESC);
//         RESTAURANT_RES.setAddress(ADDRES);
//         RESTAURANT_RES.setId(RESTAURANT_ID);
//         RESTAURANT_RES.setImage(IMAGE);
//         RESTAURANT_RES.setTurns(turns);

//     }

//     @Test
//     public void getRestaurantByIdTest() throws BookingException {
//         final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);

//         assertEquals(response.getStatus(), SUCCESS_STATUS);
//         assertEquals(response.getCode(), SUCCESS_CODE);
//         assertEquals(response.getMessage(), OK);
//         assertEquals(response.getData(), RESTAURANT_RES);

//     }

     

// }

