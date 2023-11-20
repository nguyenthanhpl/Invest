package com.example.invest.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SalesDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private Long orderDAOId;

    private Long userDAOId;

    public SalesDAO( Double amount, Long orderDAOId, Long userDAOId) {

        this.amount = amount;
        this.orderDAOId = orderDAOId;
        this.userDAOId = userDAOId;
    }

    public SalesDAO() {

    }
}
