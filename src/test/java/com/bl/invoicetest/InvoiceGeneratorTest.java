package com.bl.invoicetest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @BeforeClass
    //for creating dummy users and his dummy rides
    public static void creatingUserInRideRepository(){
        InvoiceService invoiceService = new InvoiceService();

        String userId="user1234";
        invoiceService.addUser(userId, null);                       //creating a new dummy User with userid=user1234, returns true if successfully added
        invoiceService.addUsersRide( userId,new Ride(5,5,false) );//Adding his dummy normal ride, returns true if successfully added
        invoiceService.addUsersRide( userId,new Ride(50,100, false) );//Adding his dummy normal ride, returns if successfully added

        userId="user1000";
        invoiceService.addUser(userId, null);                       //creating a new dummy User with userid=user1000, returns true if successfully added
        invoiceService.addUsersRide( userId,new Ride(5,5,false) );//Adding his dummy normal ride, returns true if successfully added
        invoiceService.addUsersRide( userId,new Ride(50,100, false) );//Adding his dummy normal ride, returns if successfully added
        invoiceService.addUsersRide( userId, new Ride(10,10,true ) );//Adding his dummy premium ride, returns true if successfully added
    }

    @Test
    public void givenDistanceAndTime_whenTotalFairIsMoreThanMinimumFair_ShouldReturnTotalFair() {
        double result = invoiceGenerator.generateInvoice(35, 35, false);
        Assert.assertEquals(385.0, result,0.0);
    }

    @Test
    public void givenDistanceAndTime_whenTotalFairIsLessThanMinimumFair_shouldReturnMinimumFareElseTotalFair() {
        double result = invoiceGenerator.generateInvoice(0.2, 2, false);
        Assert.assertEquals(5, result, 0.0);
    }

    @Test
    public void givenMultipleRideDetails_whenRideIsMoreThanOne_shouldReturnInvoiceWithTotalRidesTotalFareAndAverageFare() {
        List<Ride> rides = Arrays.asList( new Ride(5, 5, false), new Ride(50, 100, false) );
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
        Assert.assertEquals(new Invoice(2, 655, 327.5), invoice);
    }


    @Test
    public void givenAUserId_whenUserIdIsValid_shouldGetTheListOfAllRidesAndReturnTheInvoice() {

       String userId = "user1234";      //this user already having 2 normal rides added at @BeforeClass
       InvoiceService invoiceService = new InvoiceService();

        List <Ride> rides = null;
        try {
            rides = invoiceService.getRides(userId);
        } catch (UserNotFoundException e) {
            System.out.println( e.getMessage() );
        }
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
       Assert.assertEquals(new Invoice(2, 655, 327.5), invoice);

    }

    @Test
    public void givenAUserIdHavingPremiumAndNormalRides_whenUserIsValid_shouldGetTheListOfAllRidesAndReturnTheInvoice() {
        InvoiceService invoiceService = new InvoiceService();

        String userId = "user1000";  //this user already having 2 normal rides and 1 premium ride added at @BeforeClass

        List <Ride> rides = null;
        try {
            rides = invoiceService.getRides(userId);
        } catch (UserNotFoundException e) {
            System.out.println( e.getMessage() );
        }
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
        Assert.assertEquals(new Invoice(3, 825, 275), invoice);

    }

}
