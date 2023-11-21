package com.example.invest.Entity;

import lombok.Data;

@Data
public class RewardProduct {
    private Long id;
    private Double point;

    private Long userId;
    private  Long orderId;
    private String type;
    public RewardProduct(Long order) {
        this.orderId = order;
    }

    public RewardProduct( Double point, Long userId, Long order, String type) {
        this.point = point;
        this.userId = userId;
        this.orderId = order;
        this.type = type;
    }

    public RewardProduct( Double point, Long userId, String type) {
        this.point = point;
        this.userId = userId;
//        this.orderId = order;
        this.type = type;
    }


}
