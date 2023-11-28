package com.example.invest.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RewardSystemDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double point;
    private Long userDAOId;
    private Type type;

    public RewardSystemDAO(Double point, Long userDAOId, Type type) {
        this.point = point;
        this.userDAOId = userDAOId;
        this.type = type;
    }

    public RewardSystemDAO() {

    }

    public enum Type {
        Deposit, Withdraw
    }
}
