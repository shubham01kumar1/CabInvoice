package com.bl.invoicetest;

import java.util.List;

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

    public Invoice generateInvoice (List<Ride> rides) {
        if( rides == null) {
            return new Invoice(0, 0, 0);
        }
        double totalFare = 0;
        int totalRides = rides.size();

        for (Ride ride : rides) {
            totalFare += generateInvoice(ride.getDistance(), ride.getTime());
        }
        double avgFare = totalFare/totalRides;
        return new Invoice(totalRides, totalFare, avgFare);
    }

}

