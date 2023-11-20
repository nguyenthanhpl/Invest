package com.example.invest.Entity;

import lombok.Data;

import java.util.Date;
@Data

public class Order {

    private Long id;
    private Double amount;
    private Date day;
    private Date dayLimit;
    private Long productType;
    private final Long userId;

    public Order(Long user) {
        this.userId = user;
    }


    public Order( Double amount, Date day, Date dayLimit, Long productType,Long user) {

        this.amount = amount;
        this.day = day;
        this.dayLimit = dayLimit;
        this.productType = productType;
        this.userId = user;
    }



    public Order(Long id, Double amount, Date day, Date dayLimit, Long productType, Long userId) {
        this.id = id;
        this.amount = amount;
        this.day = day;
        this.dayLimit = dayLimit;
        this.productType = productType;
        this.userId = userId;
    }
}
