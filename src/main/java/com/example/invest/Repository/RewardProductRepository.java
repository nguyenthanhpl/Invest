package com.example.invest.Repository;

import com.example.invest.DAO.RewardProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardProductRepository extends JpaRepository<RewardProductDAO, Long> {
}
