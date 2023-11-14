package com.example.invest.Repository;

import com.example.invest.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDAO,Long> {



}
