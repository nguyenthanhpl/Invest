package com.example.invest.Services;

import com.example.invest.Entity.User;

public interface UserService {
    public User findById(Long id);

    public Long totalChild(String parentAddress);

    public Double totalChildPoint(String parentAddress);

    public Long getParentAddressID(Long userId);

    public String getParentAddress(Long userId);
}
