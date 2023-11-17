package com.example.invest.Services;

import com.example.invest.DAO.OrderDAO;
import com.example.invest.DTO.OrderDTO;
import com.example.invest.Entity.Order;

public interface OrderService {
    public void create(OrderDTO orderDTO);

    public Order findById(Long orderId);

    public Long findUserById(Long orderId);

    public Double getAmount(Long orderId);


}
