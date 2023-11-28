package com.example.invest.Services;


import com.example.invest.DTO.ClaimDTO;
import com.example.invest.Entity.Order;
import org.springframework.stereotype.Service;

@Service
public abstract class RewardServiceAbs {

    public abstract String create(Order order);

    public abstract String withdraw(ClaimDTO claimDTO);
}

