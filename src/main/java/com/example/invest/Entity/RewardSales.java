package com.example.invest.Entity;

import lombok.Data;

@Data
public class RewardSales {
    private Long id;
    private Long orderId;
    private Long userId;
    private Double amount;
    private String type;
    public RewardSales( Long orderId, Long userId, Double amount,String type) {

        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
    }

    public RewardSales(  Long userId, Double amount,String type) {

//        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
    }
}
