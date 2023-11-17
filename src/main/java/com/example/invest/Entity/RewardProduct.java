package com.example.invest.Entity;

import lombok.Data;

@Data
public class RewardProduct {
    private Long id;
    private Double point;
    private final Long orderId;

    public RewardProduct(Long order) {
        this.orderId = order;
    }

    public RewardProduct( Double point, Long order) {
        this.point = point;
        this.orderId = order;
    }

//    public Thread getOrder() {
//    }
}
