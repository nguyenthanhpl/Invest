package com.example.invest.DAO;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class OrderDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Double value;
    private Date day;
    private Date dayLimit;
    private Long productType;

    @ManyToOne
    @JoinColumn(name = "userDAO_id")
    private UserDAO userDAO;

    @OneToOne(mappedBy = "orderDAO")
    private RewardProduct rewardProduct;
}
