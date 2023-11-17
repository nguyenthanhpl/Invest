package com.example.invest.Repository;

import com.example.invest.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDAO,Long> {

    @Query(value = "SELECT count(ud.id) from UserDAO as ud where ud.parentAddress = :child")
    Long totalChild(@Param("child") String child);

//    @Query(value = "SELECT sum(od.amount) from UserDAO as ud inner join OrderDAO  as od on(ud.id = od.userDAOId) where ud.parentAddress = :child")
//    Double totalChildPoint(@Param("child") String child);

    @Query(value = "SELECT ud.id from UserDAO as ud where ud.publicAddress = :parentAddress")
    Long getParentAddressId(@Param("parentAddress") String parentAddress);

    @Query(value = "SELECT ud.parentAddress from UserDAO as ud where ud.id = :uid")
    String getParentAddress(@Param("uid") Long uid);

    @Query(value = "SELECT ud.publicAddress from UserDAO as ud where ud.id = :uid")
    String getPublicAddress(@Param("uid") Long uid);
}
