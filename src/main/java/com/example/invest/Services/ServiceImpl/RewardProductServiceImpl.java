package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.RewardProductDAO;
import com.example.invest.DTO.RewardProductDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.RewardProduct;
import com.example.invest.Repository.RewardProductRepository;
import com.example.invest.Services.RewardProductService;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        RewardProduct rewardProduct = new RewardProduct(order.getAmount(), order.getUserId(), order.getId(), "deposit");

        rewardProductRepository.save(mapperRewardProduct(rewardProduct));
    }

    @Override
    public String unDeposit(RewardProductDTO rewardProductDTO) {
        Double balance = rewardProductRepository.checkTotalPoint(rewardProductDTO.getUserDTOId());
        if (balance >= rewardProductDTO.getPoint()) {
            RewardProduct rewardProduct = new RewardProduct(rewardProductDTO.getPoint(), rewardProductDTO.getUserDTOId(), "undeposit");
            rewardProductRepository.save(mapperRewardProduct(rewardProduct));
            return "thành Công";
        }
        return "thất bại";
    }


    //    @Override
//    public Double getTotalPointDeposit(Long userId) {
//        Double totalPoint = rewardProductRepository.getTotalPointDeposit(userId);
//        return totalPoint;
//    }

//    public Double getTotalPointUnDeposit(Long userId) {
//        Double totalPoint = rewardProductRepository.getTotalPointUnDeposit(userId);
//        return totalPoint;
//    }

    private RewardProductDAO mapperRewardProduct(RewardProduct rewardProduct) {
        RewardProductDAO rewardProductDAO = new RewardProductDAO();
        rewardProductDAO.setPoint(rewardProduct.getPoint());
        rewardProductDAO.setUserDAOId(rewardProduct.getUserId());
        rewardProductDAO.setOrderDAOId(rewardProduct.getOrderId());
        rewardProductDAO.setType(rewardProduct.getType());
        return rewardProductDAO;
    }
}
