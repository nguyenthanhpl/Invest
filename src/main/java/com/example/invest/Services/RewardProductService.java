package com.example.invest.Services;

import com.example.invest.Entity.Order;

import java.util.List;

public interface RewardProductService {
    public void create(Order order);

    public Double getTotalPoint(Long userId);

    public List<Long>  getTotalParentQualified(Order order);
}
