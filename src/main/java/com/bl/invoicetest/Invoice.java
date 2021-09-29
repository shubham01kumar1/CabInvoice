package com.bl.invoicetest;

public class Invoice {
    private int totalRides;
    private double totalFare;
    private double avgFare;

    public Invoice(int totalRides, double totalFare, double avgFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return totalRides == invoice.totalRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.avgFare, avgFare) == 0;
    }

}
