package com.example.invest.DTO;

import lombok.Data;

@Data
public class RewardSalesDTO {

    private Long id;
    private Long orderDTOId;
    private Long userDTOId;
    private Double amount;
}
