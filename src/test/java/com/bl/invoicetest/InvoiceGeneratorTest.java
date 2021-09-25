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
    public void givenDistanceAndTime_whenTotalFairIsLessThanMinimumFair_ShouldReturnMinimumFareElseTotalFair() {
        double result = invoiceGenerator.generateInvoice(0.2, 2);
        Assert.assertEquals(5, result, 0.0);
    }

}
