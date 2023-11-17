package com.example.invest.Services;

import com.example.invest.Entity.Order;
import com.example.invest.Entity.User;

import java.util.List;

public interface UserService {
    public User findById(Long id);

    public Long totalChild(String parentAddress);

//    public Double totalChildPoint(String parentAddress);

    public Long getParentAddressID(Long userId);

    public String getParentAddress(Long userId);

    public  String getPublicAddress(Long userid);

//    public List<Long> getListParentById(Long order);
    public List<Long> getListParentById(Order order);
}
