package com.bl.invoicetest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @BeforeClass
    //for creating a dummy user and his dummy rides
    public static void creatingUserInRideRepository(){
        InvoiceService invoiceService = new InvoiceService();
        String userId="user1234";
        invoiceService.addUser(userId, null);                       //creating a dummy User with userid, returns true if successfully added
        invoiceService.addUsersRide( userId,new Ride(5,5) );//Adding his dummy ride, returns true if successfully added
        invoiceService.addUsersRide( userId,new Ride(50,100) );//Adding his dummy ride, returns if successfully added
    }

    @Test
    public void givenDistanceAndTime_whenTotalFairIsMoreThanMinimumFair_ShouldReturnTotalFair() {
        double result = invoiceGenerator.generateInvoice(35, 35);
        Assert.assertEquals(385.0, result,0.0);
    }

    @Test
    public void givenDistanceAndTime_whenTotalFairIsLessThanMinimumFair_shouldReturnMinimumFareElseTotalFair() {
        double result = invoiceGenerator.generateInvoice(0.2, 2);
        Assert.assertEquals(5, result, 0.0);
    }

    @Test
    public void givenMultipleRideDetails_whenRideIsMoreThanOne_shouldReturnInvoiceWithTotalRidesTotalFareAndAverageFare() {
        List<Ride> rides = Arrays.asList( new Ride(5, 5), new Ride(50, 100) );
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
        Assert.assertEquals(new Invoice(2, 655, 327.5), invoice);
    }


    @Test
    public void givenAUserId_whenUserIdIsValid_shouldGetTheListOfRidesAndReturnTheInvoice() {

       String userID = "user1234";
       InvoiceService invoiceService = new InvoiceService();
        List <Ride> rides = null;
        try {
            rides = invoiceService.getRides(userID);
        } catch (UserNotFoundException e) {
            System.out.println( e.getMessage() );
        }
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
       Assert.assertEquals(new Invoice(2, 655, 327.5), invoice);

    }

}
