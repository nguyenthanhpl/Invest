package com.example.invest.Services;

import com.example.invest.DTO.ClaimDTO;
import com.example.invest.DTO.RewardSalesDTO;
import com.example.invest.Entity.Order;

public interface RewardSalesService {

    public String create(Order order);
    public String withdraw(ClaimDTO claimDTO);
}
