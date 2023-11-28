package com.example.invest.Entity;

import lombok.Data;

@Data
public class RewardProduct {
    private Long id;
    private Double point;

    private Long userId;
    private  Long productId;
    private Type type;
    public RewardProduct(Long order) {
        this.productId = order;
    }

    public RewardProduct( Double point, Long userId, Long productId, Type type) {
        this.point = point;
        this.userId = userId;
        this.productId = productId;
        this.type = type;
    }

    public RewardProduct( Double point, Long userId, Type type) {
        this.point = point;
        this.userId = userId;
//        this.orderId = order;
        this.type = type;
    }

    public enum Type{
        Deposit,Withdraw
    }

}
