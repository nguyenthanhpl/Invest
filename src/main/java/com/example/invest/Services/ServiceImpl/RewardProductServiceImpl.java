package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.RewardProductDAO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.RewardProduct;
import com.example.invest.Repository.RewardProductRepository;
import com.example.invest.Services.OrderService;
import com.example.invest.Services.RewardProductService;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardProductServiceImpl implements RewardProductService {

//    @Autowired
//    OrderService orderService;

    @Autowired
    RewardProductRepository rewardProductRepository;



    @Autowired
    UserService userService;

    @Override
    public void create(Order order) {

        RewardProduct rewardProduct = new RewardProduct(order.getAmount(), order.getUserId(), order.getId());
        rewardProductRepository.save(mapperRewardProduct(rewardProduct));
    }

    @Override
    public Double getTotalPoint(Long userId) {
        return rewardProductRepository.getTotalPoint(userId);
    }

    @Override
    public List<Long> getTotalParentQualified(Order order) {
        List<Long> totalParent = userService.getListParentById(order);
        List<Long> parentsQualified = new ArrayList<>();
        for (Long parent : totalParent) {
            String getAddRestPublic = userService.getPublicAddress(parent);
            Long child = userService.totalChild(getAddRestPublic);
            if (child >= 3) {
                parentsQualified.add(parent);
            }
        }
        return parentsQualified;
    }

    private RewardProductDAO mapperRewardProduct(RewardProduct rewardProduct) {
        RewardProductDAO rewardProductDAO = new RewardProductDAO();
        rewardProductDAO.setPoint(rewardProduct.getPoint());
        rewardProductDAO.setUserDAOId(rewardProduct.getUserId());
        rewardProductDAO.setOrderDAOId(rewardProduct.getOrderId());
        return rewardProductDAO;
    }
}
