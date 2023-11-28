package com.example.invest.Repository;

import com.example.invest.DAO.RewardProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RewardProductRepository extends JpaRepository<RewardProductDAO, Long> {
//    @Query(value = "select sum(rp.point) from RewardProductDAO as rp where rp.userDAOId = :uid and rp.type = 'deposit'")
//    Double getTotalPointDeposit(@Param("uid") Long uid);
//
//    @Query(value = "select sum(rp.point) from RewardProductDAO as rp where rp.userDAOId = :uid and rp.type = 'undeposit'")
//    Double getTotalPointUnDeposit(@Param("uid") Long uid);

    @Query(value = "SELECT COALESCE(rs1, 0) - COALESCE(rs2, 0) FROM "
            + "(SELECT SUM(rp1.point) AS rs1 FROM RewardProductDAO AS rp1 WHERE rp1.type = 0 AND rp1.userDAOId = :uid AND rp1.productDAOId = :pid) AS subquery1, "
            + "(SELECT SUM(rp2.point) AS rs2 FROM RewardProductDAO AS rp2 WHERE rp2.type = 1 AND rp2.userDAOId = :uid AND rp2.productDAOId = :pid) AS subquery2")
    Double checkTotalPoint(@Param("uid") Long uid, @Param("pid") Long pid);
}
