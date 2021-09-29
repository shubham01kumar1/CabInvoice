package com.bl.invoicetest;

public class Ride {

    private double distance;
    private int time;
    private boolean premiumRide;

    public Ride( double distance, int time) {
        this.distance = distance;
        this.time = time;
    }
    public Ride( double distance, int time, boolean premiumRide ) {
        this.distance = distance;
        this.time = time;
        this.premiumRide = premiumRide;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public boolean isPremiumRide() {
        return premiumRide;
    }
}
