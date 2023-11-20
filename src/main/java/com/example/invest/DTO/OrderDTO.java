package com.example.invest.DTO;

import lombok.Data;

import java.util.Date;
@Data

public class OrderDTO {

    private Long id;
    private Double amount;
    private Date day;
    private Date dayLimit;
    private Long productType;
    private Long uid;


}
