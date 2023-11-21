package com.example.invest.Repository;

import com.example.invest.DAO.RewardProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RewardProductRepository extends JpaRepository<RewardProductDAO, Long> {
    @Query(value = "select sum(rp.point) from RewardProductDAO as rp where rp.userDAOId = :uid and rp.type = 'deposit'")
    Double getTotalPointDeposit(@Param("uid") Long uid);

    @Query(value = "select sum(rp.point) from RewardProductDAO as rp where rp.userDAOId = :uid and rp.type = 'undeposit'")
    Double getTotalPointUnDeposit(@Param("uid") Long uid);

    @Query(value = "SELECT (rs1 - rs2) FROM "
            + "(SELECT SUM(rp1.point) AS rs1 FROM RewardProductDAO AS rp1 WHERE rp1.type = 'deposit' AND rp1.userDAOId = :uid) AS subquery1, "
            + "(SELECT SUM(rp2.point) AS rs2 FROM RewardProductDAO AS rp2 WHERE rp2.type = 'undeposit' AND rp2.userDAOId = :uid) AS subquery2")
    Double checkTotalPoint(@Param("uid") Long uid);
}
