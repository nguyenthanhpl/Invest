package com.example.invest.Services;

import com.example.invest.DTO.ClaimDTO;
import com.example.invest.Entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface RewardService<E, T> {

    public String create(E e);

    public String withdraw(T t);
}
