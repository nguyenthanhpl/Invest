package com.example.invest.Entity;

import lombok.Data;

@Data
public class RewardSystem {
    private Long id;
    private Double point;
    private Long userId;
    private Type type;

    public enum Type {
        Deposit, Withdraw
    }

    public RewardSystem(Double point, Long userId, Type type){
        this.point = point;
        this.userId = userId;
        this.type = type;
    }
}
