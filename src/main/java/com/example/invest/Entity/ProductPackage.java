package com.example.invest.Entity;

public class ProductPackage {
    private double minPrice;
    private double maxPrice;
    private double profitPercentage;
    private final double monthlyInterestRate = 0.05;
    private static final int PEROID = 20;

    public ProductPackage(double minPrice, double maxPrice, double profitPercentage) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.profitPercentage = profitPercentage;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(minPrice) ^ Double.hashCode(maxPrice);
    }
}
