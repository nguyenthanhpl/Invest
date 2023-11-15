package com.example.invest.DAO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RewardProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Double point;

    @OneToOne
    @JoinColumn(name = "orderDAO_id",referencedColumnName = "id")
    private OrderDAO orderDAO;
}
