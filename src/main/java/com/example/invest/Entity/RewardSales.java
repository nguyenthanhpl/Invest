package com.example.invest.Entity;

import lombok.Data;

@Data
public class RewardSales {
    private Long id;
    private Long productId;
    private Long userId;
    private Double amount;
    private Type type;
    public RewardSales( Long productId, Long userId, Double amount,Type type) {

        this.productId = productId;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
    }

    public RewardSales(  Long userId, Double amount,Type type) {

//        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
    }
    public enum Type{
        Deposit,Withdraw;
    }
}
