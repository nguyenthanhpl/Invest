package com.example.invest.Repository;

import com.example.invest.DAO.RewardSalesDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RewardSalesRepository extends JpaRepository<RewardSalesDAO, Long> {

    @Query(value = "SELECT COALESCE(rs1, 0) - COALESCE(rs2, 0) FROM "
            + "(SELECT SUM(rp1.amount) AS rs1 FROM RewardSalesDAO AS rp1 WHERE rp1.type = 0 AND rp1.userDAOId = :uid) AS subquery1,"
            + "(SELECT SUM(rp2.amount) AS rs2 FROM RewardSalesDAO AS rp2 WHERE rp2.type = 1 AND rp2.userDAOId = :uid) AS subquery2")
    Double checkTotalPoint(@Param("uid") Long uid);
}
