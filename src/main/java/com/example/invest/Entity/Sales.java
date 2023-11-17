package com.example.invest.Entity;

import lombok.Data;

@Data

public class Sales {

    private Long id;
    private Long orderId;
    private Long userId;
    private Double amount;;

    public Sales( Long orderId, Long userId, Double amount) {

        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
    }
}
