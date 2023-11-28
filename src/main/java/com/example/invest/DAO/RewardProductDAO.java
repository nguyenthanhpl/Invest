package com.example.invest.DAO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RewardProductDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Double point;
    private Long userDAOId;
    private Long productDAOId;
    private Type type;

    public enum Type{
        Deposit,Withdraw
    }
}
