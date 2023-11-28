package com.example.invest.Services.ServiceImpl;

import com.example.invest.DAO.RewardSystemDAO;
import com.example.invest.DTO.ClaimDTO;
import com.example.invest.Entity.Order;
import com.example.invest.Entity.RewardSystem;
import com.example.invest.Repository.RewardSystemRepository;
import com.example.invest.Services.RewardServiceAbs;
import com.example.invest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardSystemImpl extends RewardServiceAbs {

    @Autowired
    RewardSystemRepository rewardSystemRepository;

    @Autowired
    UserService userService;

    @Override
    public String create(Order order) {
        Long parent1 = userService.getParentAddressID(order.getUserId());
        RewardSystem.Type type = RewardSystem.Type.Deposit;
        if (parent1 != null) {
            Long parent2 = userService.getParentAddressID(parent1);
            if (parent2 != null) {
                Double point1 = 0.1 * order.getAmount();
                Double point2 = 0.05 * order.getAmount();
                RewardSystem rewardSystem1 = new RewardSystem(point1, parent1, type);
                RewardSystem rewardSystem2 = new RewardSystem(point2, parent2, type);
                rewardSystemRepository.save(mapperRewardSystem(rewardSystem1));
                rewardSystemRepository.save(mapperRewardSystem(rewardSystem2));
                return "thanh cong";
            } else {
                Double point1 = 0.15 * order.getAmount();
                RewardSystem rewardSystem1 = new RewardSystem(point1, parent1, type);
                rewardSystemRepository.save(mapperRewardSystem(rewardSystem1));
                return "thanh cong";
            }
        }
        return "that bai";
    }

    @Override
    public String withdraw(ClaimDTO claimDTO) {
        Double balance = rewardSystemRepository.checkTotalPoint(claimDTO.getUserDTOId());
        RewardSystem.Type type = RewardSystem.Type.Withdraw;
        if (balance.longValue() != 0) {
            RewardSystem rewardSystem = new RewardSystem(balance, claimDTO.getUserDTOId(), type);
            rewardSystemRepository.save(mapperRewardSystem(rewardSystem));
            return "thành Công";
        }
        return "thất bại";
    }

    private RewardSystemDAO mapperRewardSystem(RewardSystem rewardSystem) {
        if (rewardSystem.getType().equals(RewardSystem.Type.Deposit)) {
            RewardSystemDAO.Type type = RewardSystemDAO.Type.Deposit;
            RewardSystemDAO rewardSystemDAO = new RewardSystemDAO(rewardSystem.getPoint(), rewardSystem.getUserId(), type);
            return rewardSystemDAO;
        } else {
            RewardSystemDAO.Type type = RewardSystemDAO.Type.Withdraw;
            RewardSystemDAO rewardSystemDAO = new RewardSystemDAO(rewardSystem.getPoint(), rewardSystem.getUserId(), type);
            return rewardSystemDAO;
        }
    }

}
