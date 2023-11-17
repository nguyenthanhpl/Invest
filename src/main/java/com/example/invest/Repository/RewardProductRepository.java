package com.example.invest.Repository;

import com.example.invest.DAO.RewardProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RewardProductRepository extends JpaRepository<RewardProductDAO, Long> {
    @Query(value = "select sum(rp.point) from RewardProductDAO as rp where rp.userDAOId = :uid ")
    Double getTotalPoint(@Param("uid") Long uid);
}
