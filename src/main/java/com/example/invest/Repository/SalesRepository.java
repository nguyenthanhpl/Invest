package com.example.invest.Repository;

import com.example.invest.DAO.SalesDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalesRepository extends JpaRepository<SalesDAO, Long> {

    @Query(value = "select sum(s.amount) from SalesDAO as s where s.userDAOId = :uid ")
    Double getTotalPoint(@Param("uid") Long uid);
}
