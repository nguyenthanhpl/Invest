package com.example.invest.Entity;

import lombok.Data;

@Data
public class RewardSales {
    private Long id;
    private Long orderId;
    private Long userId;
    private Double amount;

    public RewardSales( Long orderId, Long userId, Double amount) {

        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
    }
}
