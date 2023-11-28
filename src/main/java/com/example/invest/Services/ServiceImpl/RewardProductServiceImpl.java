package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.RewardProductDAO;
import com.example.invest.DTO.ClaimDTO;
import com.example.invest.DTO.RewardProductDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.RewardProduct;
import com.example.invest.Repository.RewardProductRepository;
import com.example.invest.Services.RewardProductService;
import com.example.invest.Services.RewardServiceAbs;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardProductServiceImpl extends RewardServiceAbs {

//    @Autowired
//    OrderService orderService;

    @Autowired
    RewardProductRepository rewardProductRepository;


    @Autowired
    UserService userService;

    @Override
    public String create(Order order) {
        RewardProduct.Type type = RewardProduct.Type.Deposit;
        RewardProduct rewardProduct = new RewardProduct(order.getAmount(), order.getUserId(), order.getProductType(), type);

        rewardProductRepository.save(mapperRewardProduct(rewardProduct));
        return "thanh cong";
    }

    @Override
    public String withdraw(ClaimDTO claimDTO) {
        Double balance = rewardProductRepository.checkTotalPoint(claimDTO.getUserDTOId(), claimDTO.getProductDTOId());
        RewardProduct.Type type = RewardProduct.Type.Withdraw;
        if (balance.longValue() != 0) {
            RewardProduct rewardProduct = new RewardProduct(balance, claimDTO.getUserDTOId(), claimDTO.getProductDTOId(), type);
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
        rewardProductDAO.setProductDAOId(rewardProduct.getProductId());
        if(rewardProduct.getType().equals(RewardProduct.Type.Deposit))
        {
            RewardProductDAO.Type type = RewardProductDAO.Type.Deposit;
            rewardProductDAO.setType(type);
        }
        else{
            RewardProductDAO.Type type = RewardProductDAO.Type.Withdraw;
            rewardProductDAO.setType(type);
        }
        return rewardProductDAO;
    }
}
