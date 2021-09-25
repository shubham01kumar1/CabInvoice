package com.bl.invoicetest;

public class InvoiceGenerator {

    private static final int COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    public double generateInvoice ( double distance, int time ) {
        double totalFare = InvoiceGenerator.COST_PER_KILOMETER * distance + COST_PER_MINUTE * time;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }

    public double generateInvoice (Ride[] rides) {
        double totalFare = 0;

        for (Ride ride : rides) {
            totalFare += generateInvoice(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

}

