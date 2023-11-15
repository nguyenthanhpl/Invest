package com.example.invest.Repository;

import com.example.invest.DAO.OrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDAO, Long> {
}
