package com.example.invest.Services;

import com.example.invest.Entity.Order;

public interface SalesService {
    public void create(Order order);

    public Double getTotalPoint(Long userId);
}
