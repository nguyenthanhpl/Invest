package com.example.invest.Services;

import com.example.invest.DTO.ClaimDTO;
import com.example.invest.DTO.RewardProductDTO;
import com.example.invest.Entity.Order;

import java.util.List;

public interface RewardProductService {
    public String create(Order order);

//    public Double getTotalPoint(Long userId);

//    public List<Long>  getTotalParentQualified(Order order);

    public String withdraw(ClaimDTO claimDTO);
}
