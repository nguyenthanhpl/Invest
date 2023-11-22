package com.example.invest.Services;

import com.example.invest.DTO.RewardSalesDTO;
import com.example.invest.Entity.Order;

public interface RewardSalesService {

    public void rewardSharUser(Order order);
    public String unDeposit(RewardSalesDTO rewardSalesDTO);
}
