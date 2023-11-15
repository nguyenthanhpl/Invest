package com.example.invest.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class OrderDTO {

    private Double values;
    private Date day;
    private Date dayLimit;
    private Long productType;
    private Long uid;
}
