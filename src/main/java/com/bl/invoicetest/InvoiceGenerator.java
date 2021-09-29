package com.bl.invoicetest;

import java.util.List;

public class InvoiceGenerator {

    private static final int COST_PER_KILOMETER_NORMAL_RIDE = 10;
    private static final int COST_PER_MINUTE_NORMAL_RIDE = 1;
    private static final int MINIMUM_FARE_NORMAL_RIDE = 5;

    private static final int COST_PER_KILOMETER_PREMIUM_RIDE = 15;
    private static final int COST_PER_MINUTE_PREMIUM_RIDE = 2;
    private static final int MINIMUM_FARE_PREMIUM_RIDE = 20;

    public double generateInvoice ( double distance, int time,Boolean premiumRide ) {
        if ( premiumRide == false ) {
            double totalFare = InvoiceGenerator.COST_PER_KILOMETER_NORMAL_RIDE * distance + COST_PER_MINUTE_NORMAL_RIDE * time;

            if (totalFare < MINIMUM_FARE_NORMAL_RIDE) {
                return MINIMUM_FARE_NORMAL_RIDE;
            }
            return totalFare;
        }
        else {
            double totalFare = InvoiceGenerator.COST_PER_KILOMETER_PREMIUM_RIDE * distance + COST_PER_MINUTE_PREMIUM_RIDE * time;

            if (totalFare < MINIMUM_FARE_PREMIUM_RIDE) {
                return MINIMUM_FARE_PREMIUM_RIDE;
            }
            return totalFare;
        }
    }

    public Invoice generateInvoice (List<Ride> rides) {
        if( rides == null) {
            return new Invoice(0, 0, 0);
        }
        double totalFare = 0;
        int totalRides = rides.size();

        for (Ride ride : rides) {
            totalFare += generateInvoice(ride.getDistance(), ride.getTime(), ride.isPremiumRide());
        }
        double avgFare = totalFare/totalRides;
        return new Invoice(totalRides, totalFare, avgFare);
    }

}

