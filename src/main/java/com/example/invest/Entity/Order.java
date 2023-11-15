package com.example.invest.Entity;

import lombok.Data;

import java.util.Date;
@Data

public class Order {

    private Long id;
    private Double values;
    private Date day;
    private Date dayLimit;
    private Long productType;
    private User user;
}
