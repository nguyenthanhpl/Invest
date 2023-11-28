package com.example.invest.Repository;

import com.example.invest.DAO.RewardSystemDAO;
import com.example.invest.Entity.RewardSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RewardSystemRepository extends JpaRepository<RewardSystemDAO, Long> {

    @Query(value = "SELECT COALESCE(rs1, 0) - COALESCE(rs2, 0) FROM "
            + "(SELECT SUM(rp1.point) AS rs1 FROM RewardSystemDAO AS rp1 WHERE rp1.type = 0 AND rp1.userDAOId = :uid) AS subquery1,"
            + "(SELECT SUM(rp2.point) AS rs2 FROM RewardSystemDAO AS rp2 WHERE rp2.type = 1 AND rp2.userDAOId = :uid) AS subquery2")
    Double checkTotalPoint(@Param("uid") Long uid);
}
