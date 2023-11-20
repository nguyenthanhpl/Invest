package com.example.invest.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class RewardSalesDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderDAOId;
    private Long userDAOId;
    private Double amount;


    public RewardSalesDAO( Long orderDAOId, Long userDAOId, Double amount) {
        this.orderDAOId = orderDAOId;
        this.userDAOId = userDAOId;
        this.amount = amount;
    }

    public RewardSalesDAO() {

    }
}
