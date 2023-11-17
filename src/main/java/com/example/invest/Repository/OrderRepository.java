package com.example.invest.Repository;

import com.example.invest.DAO.OrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderDAO, Long> {

    @Query("select od.userDAOId from OrderDAO as od where od.id= :id")
    Long findIdUser(@Param("id") Long id);
    @Query("select od.amount from OrderDAO as od where od.id= :id")
    Double getAmount(@Param("id") Long id);
}
