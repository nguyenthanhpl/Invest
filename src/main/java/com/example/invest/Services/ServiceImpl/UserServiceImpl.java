package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.UserDAO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.User;
import com.example.invest.Repository.UserRepository;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Long id) {

        UserDAO userDAO = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is valid"));
        return mapperUser(userDAO);
    }

    @Override
    public Long totalChild(String parentAddress) {
        Long results = userRepository.totalChild(parentAddress);
        return results;
    }


    @Override
    public List<Long> getListParentById(Order order) {
        List<Long> parents = new ArrayList<>();
        Long userId = order.getUserId();
//        parents.add(userId);
        while (getParentAddress(userId) != null) {
            Long idUserParent = getParentAddressID(userId);
            userId = idUserParent;
            parents.add(userId);
        }
        return parents;
    }
//    @Override
//    public Double totalChildPoint(String parentAddress) {
//        Double results = userRepository.totalChildPoint(parentAddress);
//        return results;
//    }

    @Override
    public Long getParentAddressID(Long userId) {
        return userRepository.getParentAddressId(getParentAddress((userId)));
    }

    @Override
    public String getParentAddress(Long userId) {
        String parentAddress = userRepository.getParentAddress(userId);
        return parentAddress;
    }

    @Override
    public String getPublicAddress(Long userid) {
        return userRepository.getPublicAddress(userid);
    }


    private User mapperUser(UserDAO userDAO) {
        User user = new User(userDAO.getPublicAddress(), userDAO.getParentAddress(), userDAO.getHomeAddress(), userDAO.getPhoneNumber());
        return user;
    }


}
