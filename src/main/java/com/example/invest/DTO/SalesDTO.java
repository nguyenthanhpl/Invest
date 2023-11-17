package com.example.invest.DTO;

import lombok.Data;

@Data
public class SalesDTO {

    private Long id;

    private Double amount;

    private Long orderDTOId;

    private Long userDTOId;

}
