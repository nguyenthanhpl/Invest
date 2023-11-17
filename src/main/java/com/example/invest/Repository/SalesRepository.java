package com.example.invest.Repository;

import com.example.invest.DAO.SalesDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesDAO, Long> {
}
