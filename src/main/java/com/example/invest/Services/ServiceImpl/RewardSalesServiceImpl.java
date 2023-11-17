package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.RewardSalesDAO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.RewardSales;
import com.example.invest.Repository.RewardSalesRepository;
import com.example.invest.Services.RewardProductService;
import com.example.invest.Services.RewardSalesService;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardSalesServiceImpl implements RewardSalesService {


//    @Autowired
//    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    RewardProductService rewardProductService;

    @Autowired
    RewardSalesRepository rewardSalesRepository;

    public void rewardSharUser(Order order) {
        Double getAmount = order.getAmount();
        List<Long> parents = rewardProductService.getTotalParentQualified(order);
        List<Long> parents50 = new ArrayList<>();
        List<Long> parents200 = new ArrayList<>();
        for (Long parent : parents) {
            if (rewardProductService.getTotalPoint(parent) >= 50 && rewardProductService.getTotalPoint(parent) < 200) {
                parents50.add(parent);
            } else if (rewardProductService.getTotalPoint(parent) >= 200) {
                parents200.add(parent);
            }
        }
        if (parents50.size() != 0) {
            double present = (0.05 * getAmount) / parents50.size();
            for (Long parent : parents50) {
                RewardSales rewardSale = new RewardSales(order.getId(), parent, present);
                rewardSalesRepository.save(mapperRewardSales(rewardSale));
            }
        }
        if (parents200.size() != 0) {
            double present = (0.05 * getAmount) / parents50.size();
            for (Long parent : parents200) {
                RewardSales rewardSale = new RewardSales(order.getId(), parent, present);
                rewardSalesRepository.save(mapperRewardSales(rewardSale));
            }
        }
    }

    private RewardSalesDAO mapperRewardSales(RewardSales rewardSales) {
        RewardSalesDAO rewardSalesDAO = new RewardSalesDAO(rewardSales.getOrderId(), rewardSales.getUserId(), rewardSales.getAmount());
        return rewardSalesDAO;
    }
}
