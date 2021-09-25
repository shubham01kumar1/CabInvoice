package com.bl.invoicetest;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

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
        Ride[] rides = { new Ride(5, 5), new Ride(50, 100) };
        Invoice invoice = invoiceGenerator.generateInvoice(rides);
        Assert.assertEquals(new Invoice(2, 655, 327.5), invoice);
    }

}
