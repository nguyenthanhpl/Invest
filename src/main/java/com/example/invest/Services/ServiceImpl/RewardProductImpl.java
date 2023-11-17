package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.RewardProductDAO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.RewardProduct;
import com.example.invest.Repository.OrderRepository;
import com.example.invest.Repository.RewardProductRepository;
import com.example.invest.Services.OrderService;
import com.example.invest.Services.RewardProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardProductImpl implements RewardProductService {

    @Autowired
    OrderService orderService;

    @Autowired
    RewardProductRepository rewardProductRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void create(Long orderId) {
        Order order = orderService.findById(orderId);
        RewardProduct rewardProduct = new RewardProduct(order.getAmount(), orderId);
        rewardProductRepository.save(mapperRewardProduct(rewardProduct));
    }

    private RewardProductDAO mapperRewardProduct(RewardProduct rewardProduct) {
        RewardProductDAO rewardProductDAO = new RewardProductDAO();
        rewardProductDAO.setPoint(rewardProduct.getPoint());

        rewardProductDAO.setOrderDAOId(rewardProduct.getOrderId());
        return rewardProductDAO;
    }
}
